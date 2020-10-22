import math

#метавершина Пуля
def e1(mass, energy):
    return math.sqrt( 2 * energy / mass )
    
def e2(speed, energy):
    return 2 * energy / ( speed ** 2 )
    
def e3(speed, mass):
    return mass * ( speed ** 2 ) / 2
    

class Bullet:
    def __init__( mass, energy, speed );
    self.mass=mass
    self.energy=energy
    self.speed=speed



def e4 (depth, resistance_force):
    return depth * resistance_force
    
def e5(energy, resistance_force):
    return energe / resistance_force

def e6(energy, depth):
    return energy / depth
    

class Wall:
    def __init__( depth, energy, resistance_force):
        self.depth = depth
        self.resistance_force=resistance_force
        self.energy=energy
    
    
/* возможно, стоит обыграть через декоратор */
def to_slow_down(bullet, wall, end_speed):
    wall.energy = bullet.energy - bullet.mass * (end_speed ** 2) / 2
    
    
def to_penetrate(bullet, wall, end_speed):
    bullet.energy = wall.energy + bullet.mass * (end_speed ** 2) / 2

    