from lab_python_oop.rectangle import *
from lab_python_oop.circle import *
from lab_python_oop.square import *

if __name__ == '__main__':
    rectangle = Rectangle(3, 2, [0, 255, 0])
    circle = Circle(5, [0, 0, 255])
    square = Square(5, [255, 0, 0])

    print (repr(rectangle))
    print (repr(circle))
    print (repr(square))
