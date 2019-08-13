# Tetris 1.0 by R

Simple tetris game written in java, using JOGL library
#### Classes:
****
  - **Render**, there we have main function with fpsAnimator for rendering game frames.
  - **Piece**, there we have implemented rules for drawing and rotating for all available tetris pieces.
  - **Menu**, there we have implementation for drawing text and where to draw point if start game/how to play/exit is selected.
  - **Ingame**, there we have board implementation with drawing pieces on it, rotating them, counting points and finding out when the game is over.
  - **Game**, there we have GLEventListener and KeyListener interfaces implemented and handling which screen will be displayed(in game/menu/how to play).
  ****