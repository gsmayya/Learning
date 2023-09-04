// Object literal method
let person = {
  firstName: "XYZ",
  lastName: "ABC",
  age: 50,
  married: false,
};

person.height = "6 ft";
person.print = () => {
  console.log("Object Printed");
};
console.log(person);
person.print();
// using key board
let person2 = new Object();
person2.name = "James ";
person2.age = 60;
person2.height = "3 ft";

console.log(person2);

// Object  constructor method

let car = {
  color: "red",
  make: "mercedes",
  seats: 2,
  Car: function (color, make, seats) {
    this.color = color;
    this.make = make;
    this.seats = seats;
    return this;
  },
};

let car2 = new car.Car("Blue", "Honda", "5");
let car3 = new car.Car("Green", "Toyota", "5");
console.log(car);
console.log(car2);
console.log(car3);

let treeObj = {
  Tree: function (branches) {
    this.branches = branches;
    this.grow = function (branch) {
      this.branches.push(branch);
    };
  },
};

let tree = new treeObj.Tree([]);
tree.grow("Some");
tree.grow("Some1");
console.log(tree.branches);

// Iteration

let finalStr = "";

for (let outer = 0; outer < 5; outer++) {
  for (let start = 0; start < outer; start++) {
    finalStr += "*";
  }
  finalStr += "\n";
}

for (let outer = 5; outer > 0; outer--) {
  for (let start = outer; start > 0; start--) {
    finalStr += "*";
  }
  finalStr += "\n";
}
console.log(finalStr);
