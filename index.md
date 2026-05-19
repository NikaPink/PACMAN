---
type: TP
number: 4
---

# Programmation événementielle et liaison de données dans le jeu *Pacman*

Pour l'instant, seule la vue de votre application *Pacman* a été développée.
Nous allons maintenant y intégrer la logique du jeu, en exploitant la
programmation événementielle et la liaison de données.
Nous utiliserons en particulier des propriétés, qui nous permettront de
faciliter les interactions entre les différents composants de l'application.
À l'issue de ce TP, vous devriez être capable de :

- Utiliser des propriétés pour lier les données du modèle à la vue.
- Implémenter des écouteurs permettant de réagir à l'utilisation du clavier.

## Mise à jour du projet

Pour vous faire gagner du temps, vous allez intégrer dans votre projet plusieurs
classes qui vous permettront de représenter plusieurs éléments du jeu.

1. Récupérez les fichiers fournis dans le répertoire [`src`](src).
   Les classes qu'ils contiennent sont décrites dans le diagramme ci-dessous.

   ![Diagramme des classes fournies pour le jeu *Pacman*.](./figures/diagramme-classes.png)

## Affichage de la carte

La carte du jeu est représentée à l'aide de la classe `GameMap`, qui se
compose de tuiles fixes représentant chacune des positions possibles sur la
carte.
Chacune des tuiles contient un attribut de type `TileContent` qui permet de
représenter les différents éléments de la carte qui peuvent se trouver sur une
tuile : soit un chemin, soit un mur.
Dans cette partie, nous allons voir comment afficher la carte sur l'interface
utilisateur.

2. Adaptez la classe `Tile` pour que son attribut `TileContent` devienne une
   propriété du type approprié, comme vous l'avez fait en TD.

3. Modifiez dans la classe `PacmanController` la méthode qui initialise les
   `ImageView` pour que celle-ci puisse les lier au contenu des tuiles qui la
   composent.
   Vous devrez donc adapter le nombre d'`ImageView` à la taille de la carte.
   Attention : la *carte* n'est pas nécessairement carrée, il faut donc
   utiliser ses méthodes `getHeight()` et `getWidth()` pour connaître le nombre
   de lignes et de colonnes dont vous avez besoin.
   La méthode `initialize()` de votre contrôleur ne pourra donc plus être
   utilisée pour cela.
   Utilisez ensuite la liaison de données pour permettre de lier l'image
   affichée par une des `ImageView` à l'image correspondant à la tuile associée.
   Vous pouvez pour cela créer une propriété dont la valeur sera l'image à
   afficher pour une tuile donnée en prenant exemple sur le code ci-dessous
   (il vous faudra peut-être adapter la méthode `loadImage`) :

   ```java
   Bindings.createObjectBinding(() -> loadImage(tile.getContent().getName()),
                                tile.getContentProperty());
   ```

4. Depuis la méthode `start()` de votre application, récupérez le contrôleur
   pour pouvoir appeler la méthode définie à la question précédente en
   utilisant une carte du jeu quelconque, par exemple générée avec une des
   méthodes de `GameMapFactory` (vous pouvez utiliser les constantes définies
   dans le précédent sujet pour choisir la taille de la carte).

5. Lancez votre application pour vous assurer que la carte s'affiche
   correctement dans la fenêtre.

## Ajout des interactions avec le contrôleur

La création de la carte telle qu'elle a été faite à la question 4 devrait
normalement être gérée par une classe dont la responsabilité est de gérer une
partie (nous nous en sommes passé ici pour vérifier que tout fonctionnait bien).
Nous allons maintenant implémenter cette classe.

6. Définissez une nouvelle classe pour jouer ce rôle.
   Celle-ci devra fournir une méthode pour chaque action que l'utilisateur
   peut réaliser sur la partie.
   Vous n'avez pas nécessairement besoin de toutes les écrire maintenant,
   vous pourrez les ajoutez au fur et à mesure.

7. Ajoutez dans cette classe un attribut dont le type est celui de votre
   contrôleur, et écrivez-lui un *setter*.
   Cet attribut permettra « d'informer » le contrôleur lorsque le modèle change.

8. Ajoutez un attribut dans le contrôleur dont le type est la classe définie
   à la question 6, et écrivez-lui un *setter*.
   Il permettra au contrôleur de répercuter les actions de l'utilisateur sur
   la partie.

9. Déplacez le code de la méthode `start()` initialisant une carte et
   l'associant au contrôleur dans une méthode dédiée de votre classe gérant une
   partie.
   La carte devra être stockée dans un attribut.

10. Adaptez la méthode `start()` pour qu'elle crée une nouvelle partie,
    l'associe au contrôleur et réciproquement *via* les *setters* définis
    précédemment, et initialise une carte à l'aide de la méthode définie
    à la question précédente.

11. Relancez votre application pour vérifier qu'elle fonctionne toujours.

## Ajout du joueur

Nous allons maintenant ajouter un joueur sur la carte du jeu, qui pourra
se déplacer sur toutes les tuiles correspondant à des chemins.
La classe `Player` (qui hérite d'`AbstractCharacter`) représente le personnage
du joueur.
Il connaît sa position sur la carte.

12. Modifiez dans la classe `AbstractCharacter` les attributs stockant la
    position du personnage de manière à ce que ceux-ci soient des propriétés
    du type approprié.
    Ajoutez également un attribut correspondant à la partie en cours.
    Initialisez-le avec un paramètre dans le constructeur de cette classe, et
    adaptez les constructeurs des classes filles en conséquence.

13. Créez dans la classe gérant une partie une nouvelle méthode permettant de
    placer un personnage donné (de type `AbstractCharacter`) dans la carte du
    jeu.
    Pour cela, vous devez récupérer les tuiles « vides » de la carte à l'aide
    de sa méthode `getEmptyTiles()`, et choisir aléatoirement l'une de ces
    tuiles.
    Placez ensuite le personnage sur la tuile choisie, en renseignant
    la position du personnage à l'aide de sa méthode `setPosition()`.
    Les méthodes `getRow()` et `getColumn()` de la tuile vous donneront cette
    information.

14. Définissez dans le contrôleur une méthode permettant de lier un personnage
    à son affichage.
    Vous devez pour cela créer une `ImageView` pour l'afficher, et lier sa
    position à celle du joueur.
    Plusieurs solutions s'offrent à vous :

    - Si vous utilisez un `GridPane`, vous devez *a priori* ajouter un écouteur
      sur les propriétés `row` et `column` du personnage, et modifier dans cet
      écouteur la position de l'`ImageView` dans la grille en exploitant la
      méthode :

      ```java
      GridPane.setConstraints(view, colIndex, rowIndex);
      ```

    - Si vous utilisez un `Pane` classique, vous pouvez liez les propriétés
      `x` et `y` de l'`ImageView` à celle du personnage.
      Attention : il vous faudra tenir compte du fait que cette position est
      donnée en pixels, et donc multiplier les indices des lignes et colonnes
      par la hauteur et la largeur choisies pour les images, respectivement.

15. Ajoutez dans la partie un attribut permettant de stocker le personnage du
    joueur.
    Complétez ensuite la méthode démarrant une partie définie à la question 9
    en appelant la méthode de la question 13 pour placer ce personnage sur la
    carte, puis celle définie à la question 14 pour le faire s'afficher.

16. Lancez l'application pour voir si le personnage apparaît bien sur la carte.

## Ajout des fantômes

Les fantômes du joueur sont représentés par la classe `Ghost` (qui hérite
également de `AbstractCharacter`).
Nous allons ici les ajouter à la carte.

17. Dans votre partie, ajoutez un attribut de type `List<Ghost>` pour
    stocker les fantômes.
    Vous pouvez initialiser cette liste avec une instance de `ArrayList`.

18. Dans la méthode initialisant une partie, videz la liste définie à la
    question précédente, puis ajoutez-y un certain nombre de fantômes
    que vous devez créer à cet endroit (définissez une constante correspondant
    au nombre de fantômes à ajouter).
    Vous pouvez utiliser les images fournies dans le sujet précédent pour les
    représenter.

19. Ajoutez ces fantômes en les plaçant aléatoirement sur la carte.

20. Lancez l'application pour voir si les fantômes apparaissent bien.

## Déplacement des personnages

Maintenant que le joueur et les fantômes sont affichés, il faut leur
permettre de se déplacer sur la carte.

21. Pour chaque direction possible, implémentez une méthode permettant de
    déplacer un personnage donné d'une case dans cette direction.
    Ces méthodes doivent prendre en paramètre le personnage à déplacer, et
    vérifier que la case vers laquelle il se déplace est bien vide.
    Si c'est le cas, vous devez modifier la position du personnage en appelant
    sa méthode `setPosition()`.
    Sinon, la méthode ne fait rien.

22. Pour chacune des directions, écrivez une méthode sans paramètre qui
    permettra de déplacer le personnage du joueur dans cette direction.
    Vous devez exploiter les méthodes définies à la question précédente pour
    cela.

### Déplacement du joueur

Le joueur doit pouvoir se déplacer à l'aide des flèches du clavier.
Il faut donc implémenter le code permettant de réagir à ces touches.

23. Dans votre contrôleur, ajoutez un attribut de type `Scene` qui
    correspond à la scène de l'application, et écrivez-lui un *setter*.
    Appelez cette méthode dans la méthode `start()` de votre application.

24. Complétez le *setter* précédent pour ajouter un écouteur d'événements
    clavier sur la scène, qui réagira aux touches fléchées.
    Cet écouteur doit appeler la méthode de déplacement du joueur
    correspondant à la touche pressée.

25. Relancez l'application pour vérifier que le joueur peut se déplacer.

### Déplacement des fantômes

Les fantômes doivent quant à eux se déplacer de manière autonome.

26. Écrivez dans la classe `Ghost` une méthode permettant de choisir
    aléatoirement une direction (par exemple, en prenant un nombre aléatoire
    entre 0 et 4), et qui déplace ce personnage en passant par l'une des
    méthodes `move*()` de la façade, en leur donnant `this` en paramètre.

27. Écrivez la méthode qui va exécuter ce déplacement à intervalle régulier.
    Pour cela, on va utiliser la classe `Timeline` fournie par *JavaFX*.
    Votre méthode pourrait alors ressembler à celle donnée ci-dessous, qui
    fait faire une déplacement aléatoire au personnage chaque seconde pendant
    une durée indéterminée (`moveRandomly()` correspond à la méthode que vous
    avez définie à la question précédente) :

    ```java
    public void animate() {
        this.timeline = new Timeline(
            new KeyFrame(Duration.seconds(1), e -> moveRandomly()));
        this.timeline.setCycleCount(Animation.INDEFINITE);
        this.timeline.play();
    }
    ```

28. Modifiez la méthode initialisant une partie pour appeler la méthode
    `animate()` sur chaque fantômes créé, afin qu'ils se déplacent
    automatiquement.

29. Relancez l'application, pour le déplacement automatique des fantômes.
