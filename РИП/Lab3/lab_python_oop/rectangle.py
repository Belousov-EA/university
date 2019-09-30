from lab_python_oop.figure_color import FigureColor
from lab_python_oop.geometric_figure import GeometricFigure

class Rectangle(GeometricFigure):
    def __init__(self, height, weight, color):
        self.height = height
        self.weight = weight
        self.figure_color = FigureColor()
        self.figure_color.color = color
        self.name = 'Прямоуголник'


    def calc_square(self):
        return self.weight * self.height

    def __repr__(self):
        return 'Прямоугольник со сторонами {0} и {1},' \
               'площадью {2}, цвета {3}'.format(self.weight,
                                                self.height,
                                                self.calc_square(),
                                                self.figure_color.color)


    def get_name(self):
        return self.name



