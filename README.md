# Minecraft Bingo Generator - By OMGItZPomPom

Ce plugin permet de s'entrainer à jouer à une partie de bingo sur Minecraft.
Cela ne fait qu'écrire dans le chat des joueurs les différentes instructions.
Ce plugin ne peut générer qu'une partie par serveurs.

## Table des matières
1. Pré-requis
2. Permissions
3. Commandes
4. Comment l'utiliser
5. Licence

## 1 - Pré-requis
- Un serveur sous Spigot 1.16.5 ou plus récent.

## 2 - Permissions
- Aucune

## 3 - Commandes
- ``/bingo generate {amount}``
- ``/bingo see``
- ``/bingo reset``
- ``/bingo set ID``
- ``/bingo unset ID``

## 4 - Comment l'utiliser

Vous pouvez entrer ``/bingo help pour avoir des explications In-Game``. Mais voici un rapide guide :

### 4.1 - Démmarer une partie
``/bingo generate {amount}`` va générer N items à chercher pour la partie. Si ``{amount}`` n'est pas précisé, le bingo sera généré avec 9 items à aller chercher. Si une partie est en cours, le bingo ne sera pas regénéré. Pour regénérer une partie, il faut entrer la commande ``/bingo reset``.

### 4.2 - Visualiser les items d'une partie
``/bingo see`` vous permettra de voir tous les items de la partie à aller chercher.

### 4.3 - Réinitialiser une partie
``/bingo reset`` réinitialisera la partie et vous permettra d'en re-générer une.

### 4.4 - Marquer des items comme obtenus et les enlever

- ``/bingo set ID`` va marquer l'item numéro ``id`` comme récupéré et va l'annoncer à tous les joueurs.
- ``bingo unset ID`` va marquer l'item numéro ``id`` comme non récupéré et va l'annoncer à tous les joueurs.

### 4.5 - Téléporter tous les joueurs dans un monde

``/bingo tpall {world}`` va téléporter tous les joueurs dans le ``{world}`` monde si il est spécifié. Sinon, ils seront téléportés vers le monde ``game``.

## 5 - Licence

[![logo](https://licensebuttons.net/l/by/4.0/88x31.png)](https://creativecommons.org/licenses/by/4.0/) Ce plugin est disponible sous licence [Creative Commons Attribution 4.0 International License](https://creativecommons.org/licenses/by/4.0/deed.fr) (Voir [LICENSE.md](https://github.com/JunkJumper/MincraftBingoGenerator/blob/master/LICENSE.md)).
