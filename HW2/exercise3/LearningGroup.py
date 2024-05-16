class LearningGroup:
    def __init__(self):
        self.studentList = []

    def __str__(self):
        return str([str(student) for student in self.studentList])

    def __add__(self, other):
        if isinstance(other, Student):
            self.studentList.append(other)
        elif isinstance(other, LearningGroup):
            self.studentList.extend(other.studentList)
        return self

class Student:
    def __init__(self, name, matNr):
        self.name = name
        self.matNr = matNr

    def __str__(self):
        return self.name + ' ' + str(self.matNr)

    def __add__(self, other):
        group = LearningGroup()
        group.studentList.append(self)
        if isinstance(other, Student):
            group.studentList.append(other)
        elif isinstance(other, LearningGroup):
            group.studentList.extend(other.studentList)
        return group

if __name__ == '__main__':
    student1 = Student('Alice Wonderland', 42424242)
    student2 = Student('Bob Miller', 1564153)
    student3 = Student('Charly Robert', 4681398)

    group = student1 + student2
    group += student3  # Using the overloaded + operator of LearningGroup
    group2 = student1 + student2 + student3  # Chaining addition

    print(group)
    print(group2)