from constants import Constants
from datetime import datetime

class Functions:
    
    def __init__(self):
        """
        Clase que contiene los metodos a usar
        """
    
    saldo = 1000.00
    check = False
    movimientos = ""
        
    def validar_pass(self, password):
        now = '{0:%Y-%m-%d %H:%M:%S}'.format(datetime.now())
        self.movimientos += f"{now}: Validación de usuario\n"
        if password == Constants.PASS:
            self.check = True
        return self.check
        
    def consultar_saldo(self):
        now = '{0:%Y-%m-%d %H:%M:%S}'.format(datetime.now())
        self.movimientos += f"{now}: Consulta de saldo\n"
        return self.saldo
    
    def retirar_saldo(self, retiro):
        now = '{0:%Y-%m-%d %H:%M:%S}'.format(datetime.now())
        self.movimientos += f"{now}: Retiro de saldo {retiro}\n"
        if self.saldo >= retiro:
            self.saldo-=retiro
            return True
        else:
            return False
    
    def consulta_movimientos(self):
        now = '{0:%Y-%m-%d %H:%M:%S}'.format(datetime.now())
        self.movimientos += f"{now}: Consulta de movimientos\n"
        return self.movimientos
    
    def ingresar_saldo(self, saldo):
        now = '{0:%Y-%m-%d %H:%M:%S}'.format(datetime.now())
        self.movimientos += f"{now}: Ingreso de saldo: {saldo}\n"
        self.saldo+=saldo