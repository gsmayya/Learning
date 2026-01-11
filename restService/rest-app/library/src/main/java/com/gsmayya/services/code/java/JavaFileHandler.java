package com.gsmayya.services.code.java;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.gsmayya.services.code.utils.FileHandler;
import com.gsmayya.services.code.utils.Filter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;

public class JavaFileHandler implements FileHandler {

    private final Map<String, JavaClassProperties> properties;

    public JavaFileHandler(Map<String, JavaClassProperties> properties) {
        this.properties = properties;
    }

    public Filter getFilter() {
        return (level, path, file) -> path.endsWith(".java");
    }

    @Override
    public void handle(int level, String path, File file) {
        try {
            CompilationUnit compilationUnit = JavaParser.parse(file);
            VoidVisitorAdapter<Object> visitorAdapter = new VoidVisitorAdapter<Object>() {
                @Override
                public void visit(ClassOrInterfaceDeclaration n, Object arg) {
                    super.visit(n, arg);
                    JavaClassProperties propertiesForPath = properties.getOrDefault(path, new JavaClassProperties());
                    propertiesForPath.addClass(n.getNameAsString(), n.getExtendedTypes().toString());
                    properties.put(path, propertiesForPath);
                }

                @Override
                public void visit(MethodDeclaration md, Object arg) {
                    super.visit(md, arg);
                    JavaClassProperties propertiesForPath = properties.getOrDefault(path, new JavaClassProperties());
                    propertiesForPath.addMethod(md.getNameAsString(), md.getDeclarationAsString(true, true, true));
                    properties.put(path, propertiesForPath);
                }

                @Override
                public void visit(VariableDeclarator n, Object arg) {
                    super.visit(n, arg);
                    JavaClassProperties propertiesForPath = properties.getOrDefault(path, new JavaClassProperties());
                    propertiesForPath.addVariables(n.getNameAsString(), n.getTypeAsString());
                    properties.put(path, propertiesForPath);
                }
            };

            visitorAdapter.visit(compilationUnit, null);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
