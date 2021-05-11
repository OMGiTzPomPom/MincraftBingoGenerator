# Minecraft Bingo Generator
By OMGItZPomPom

This minecraft Bingo Generator is to help training for bingos.
It only display N blocks or items to find in a Minecraft Game.

## Table of content
1. Requirements
2. Permissions
3. Commands
4. How It Works


## Requirements
- Spigot 1.16.5

## Permissions
- None

## Commands
- ``/bingo generate``
- ``/bingo see``
- ``/bingo reset``
- ``/bingo set ID``
- ``/bingo unset ID``

## How It Works

### Starting a bingo
You just have to enter ``/bingo generate {amount}``. It will broadcast to all players the "N amount" items to collect. If a game is currently running, you will not be able to generate another one unless if you enter ``/bingo reset``. If the {amount} is not specified, it will be set to the 9 by default.

### Check out the items
By entering ``/bingo see``, you will see on your proper chat the items to collect.

### Reset a Game
By entering ``/bingo reset``, you will be abble to reset a game before generate another one.

### Set and unset items

By entering ``/bingo set ID``, you will mark the item owned. By entering ``/bingo unset ID``, you will unmark the item from the list.
Any of these two commands broadcast the items to the other players.

