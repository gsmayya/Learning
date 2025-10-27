package main

import "fmt"

func main() {
	fmt.Println("Hello World")
	var intNum int = 32767
	intNum = intNum + 1
	fmt.Println(intNum)

	var floatNum float64 = 1234567.9
	fmt.Println(floatNum)

	var result float64 = floatNum + float64(intNum)
	fmt.Println(result)

	var intNum1 int = 3
	var intNum2 int = 2

	fmt.Println(intNum1 / intNum2)
	fmt.Println(intNum1 % intNum2)

	var myString string = "Hello World"
	fmt.Println(myString)

}
