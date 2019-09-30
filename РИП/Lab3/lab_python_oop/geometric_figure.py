from abc import ABC, abstractclassmethod


class GeometricFigure(ABC):

    @abstractclassmethod
    def calc_square(self):
        pass
