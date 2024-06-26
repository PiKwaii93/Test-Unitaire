## Description

RPNCalculator est une calculatrice en notation polonaise inversée (RPN) implémentée en Java, destinée à être utilisée en ligne de commande. Elle évalue des expressions mathématiques fournies au format RPN.

## Prérequis

- JDK 8 ou version ultérieure
- Apache Maven

## Installation

1. Clonez ce dépôt GitHub :
   ```bash
   git clone https://github.com/votre-utilisateur/RPNCalculator.git
   cd RPNCalculator
   ```

## Compiler le projet

Se placer dans le répertoire Maven du projet:

```bash
cd RPNCalculator
mvn clean compile
```

## Commandes

### Exécuter l'Application

Pour exécuter l'application RPNCalculator à partir du fichier JAR généré :

```bash
java -jar target/RPNCalculator-1.0-SNAPSHOT.jar
```

### Exécuter les Tests

Pour exécuter les tests unitaires et générer un rapport de tests :

```bash
mvn test
```

### Générer le Rapport de Couverture de Tests avec JaCoCo

Pour nettoyer, exécuter les tests et générer le rapport de couverture de tests avec JaCoCo :

```bash
mvn clean test jacoco:report
```

Vous pouvez ensuite consulter le fichier :

```
RPNCalculator\target\site\jacoco\index.html
```

## Utilisation

Exemples d'expressions RPN :

* "4 2 +" (Addition)
* "4 2 -" (Soustraction)
* "4 2 *" (Multiplication)
* "3 5 8 * 7 + *" (Expression complexe)
