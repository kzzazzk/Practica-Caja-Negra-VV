## Prerequisites
- Java Development Kit (JDK)
- IntelliJ IDEA (optional, but recommended)
- Maven
- JUnit4

## Steps

### 1. Clone the Repository

```bash
git clone https://github.com/kzzazzk/Practica-Caja-Negra-VV.git
cd Practica-Caja-Negra-VV

### 2. Install BST Dependency
#### Steps
- Using IntelliJ IDEA:
  Open IntelliJ IDEA.
  File -> Project Structure.
  Under "Project Settings," select "Modules."
  Click on the "Dependencies" tab.
  Click on the '+' button and choose "JARs or directories."
  Select the BST.jar file.
  Click "Apply" and then "OK."
- Using Maven:
  If you have Maven installed on your computer, execute the following command in the project directory:
```bash
mvn install:install-file -Dfile=C:\BST.jar -DgroupId=com.BST -DartifactId=BST -Dversion=1.0 -Dpackaging=jar
