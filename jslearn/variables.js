let message = "Hello";
let number = 5;
let choice = false;

let arrMsg = ["x", "Y"]
let digitsArray = [1, 2, 3, 4];
let secondArray = digitsArray;

digitsArray.push(7)
console.log(secondArray)

let arr = [1, 2, 3, 4, 5]
const a = "A"
const b = "B"
arr.push(a)
arr.push(b)
console.log("This array contains numbers with string ", arr)



let x1 = 1;
let x2 = 2;
let x3 = 3;

let valArr = [x1 ** 2 + 3 * x1 - (2 / 3), x2 ** 2 + 3 * x2 - (2 / 3), x3 ** 2 + 3 * x3 - (2 / 3)]
console.log(valArr)
console.log("x1 > x2", valArr[0] < valArr[1])
console.log("x2 > x3", valArr[1] < valArr[2])
console.log("x3 > x1", valArr[2] < valArr[0])


// conditional 

let str = "Whadup"
let x = 2 
if (str === "Whadup") {

  switch(x) {
    case 0:
    case 1: 
    case 2: {    
      x+=1;
      console.log((3===4)?"YESH":"NOO")
      console.log(x)
      break;
    }
    default: {
      console.log("Higher")
      console.log(x)
      break;   
    }
  } 

} else  {
  console.log("SAD")
}


function logger(n1, n2) {
  return n1 + n2
}

console.log(logger(5, 4));

const adder = (n1, n2) => {
  console.log("Adder called");
  return n1 + n2
}


console.log(adder(4, 10));

f1("First");
function f1(str) {
  console.log("Called " + str)
}
f1("Last");

// But .. 
//f2("First"); // this will fail. 
let f2 = (str) => {
  console.log("Func definition " + str)
}
f2("Last");

let [a1, b1, ...rest] = [10,20,30,40,50];
console.log(a1);
console.log(b1);
console.log(rest);
let arr1=  [10,20,30,40,50];
console.log(arr1.reverse())
