## Requisitos previos
- Kit de Desarrollo Java (JDK)
- IntelliJ IDEA (opcional, pero recomendado)
- Maven
- JUnit4

## Pasos

### 1. Clonar el Repositorio

```bash
git clone https://github.com/kzzazzk/Practica-Caja-Negra-VV.git
cd Practica-Caja-Negra-VV
```
### 2. Instalar dependencia BST
#### Pasos
- Usando IntelliJ IDEA:
   1. Abrir IntelliJ IDEA.
   2. Archivo -> Estructura de Proyecto.
   3. Debajo de "Ajustes de proyecto", selecciona "Modulos".
   4. Haz click en la ventana "Dependencias"
   5. Haz clic en el botón '+' y elige "JARs o directorios."
   6. Selecciona el archivo BST.jar.
   7. Haz clic en "Aplicar" y luego en "Aceptar."
- Utilizando Maven:
  1. Si tienes Maven instalado en tu computadora, ejecuta el siguiente comando en el directorio del proyecto:
```bash
mvn install:install-file -Dfile=C:\BST.jar -DgroupId=com.BST -DartifactId=BST -Dversion=1.0 -Dpackaging=jar
