package com.craftinginterpreters.lox;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ScannerTest {

    @Test public void testCreation() {
        Scanner scanner = new Scanner("");
        assertNotNull(scanner);
    }
}
