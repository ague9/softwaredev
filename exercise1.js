// Define a Person class
class Person {
    constructor(firstName, lastName, age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}

// Define a Professor class that extends Person
class Professor extends Person {
    constructor(firstName, lastName, age, position, level, chair) {
        super(firstName, lastName, age);
        this.position = position;
        this.level = level;
        this.chair = chair;
    }

    // Method to get description of the professor
    getDescription() {
        return `${this.firstName} ${this.lastName}, Chair: ${this.chair}`;
    }

    // Method to get information about the professor
    getInfo() {
        return `${this.getDescription()}, Level: ${this.level}, Position: ${this.position}`;
    }
}

// Define a role for head of the examination board
class HeadOfExaminationBoard extends Professor {
    constructor(firstName, lastName, age, position, level, chair) {
        super(firstName, lastName, age, position, level, chair);
        this.title = "Head of Examination Board";
    }

    // Override getInfo method
    getInfo() {
        return `${super.getInfo()}, Title: ${this.title}`;
    }

    // Override getDescription method
    getDescription() {
        return `${super.getDescription()}, Title: ${this.title}`;
    }
}

// Define a role for head of the department
class HeadOfDepartment extends Professor {
    constructor(firstName, lastName, age, position, level, chair) {
        super(firstName, lastName, age, position, level, chair);
        this.title = "Head of Department";
    }

    // Override getInfo method
    getInfo() {
        return `${super.getInfo()}, Title: ${this.title}`;
    }

    // Override getDescription method
    getDescription() {
        return `${super.getDescription()}, Title: ${this.title}`;
    }
}

// Create instances of the roles
const headOfExaminationBoard = new HeadOfExaminationBoard("John", "Doe", 45, "Head Professor", "W3", "Engineering");
const headOfDepartment = new HeadOfDepartment("Jane", "Smith", 50, "Senior Professor", "W2", "Computer Science");

// Print the results
console.log(headOfExaminationBoard.getInfo());
console.log(headOfDepartment.getInfo());
