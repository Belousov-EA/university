from lab_python_oop.figure_color import FigureColor
from lab_python_oop.geometric_figure import GeometricFigure
from math import pi

class Circle(GeometricFigure):
    def __init__(self, radius, color):
        self.radius = radius
        self.figure_color = FigureColor()
        self.figure_color.color = color
        self.name = 'Круг'


    def calc_square(self):
        return pi*self.radius**2


    def __repr__(self):
        return 'Круг с радиусом {0}, площадью {1}, цвета {2}'.format(self.radius,
                                                                     self.calc_square(),
                                                                     self.figure_color.color)

    def get_name(self):
        return self.name