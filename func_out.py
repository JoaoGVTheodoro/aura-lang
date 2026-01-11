name = 'World'
age = 42
def greet(person):
    greeting = ('Hello, ' + person)
    return greeting
class User:
    name = None
    age = None
    def __init__(self, name, age):
                self.name = name
                self.age = age
    def display(self):
                msg = ((self.name + ' is ') + self.age)
                return msg

