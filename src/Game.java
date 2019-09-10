import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.util.FPSAnimator;

import java.awt.Color;

public class Game implements GLEventListener, KeyListener
{
    private boolean m_Ingame;
    private boolean m_HowToPlay;
    private GL2 m_GL2;
    private Menu m_Menu;
    private Ingame m_Game;
    private int m_Selection;
    private FPSAnimator animator;
    
    public void setAnimator(FPSAnimator a) 
    {
    	animator = a;
    }
    
    @Override
    public void init(GLAutoDrawable _drawable) 
    {
        m_GL2 = _drawable.getGL().getGL2();
        m_GL2.glEnable(GL2.GL_DEPTH_TEST);
        m_Menu = new Menu(m_GL2);
        m_Game = new Ingame(m_GL2);
        m_Ingame = false;
        m_HowToPlay = false;
        m_Selection = 1;
    }

    @Override
    public void dispose(GLAutoDrawable _drawable) 
    {
    }

    @Override
    public void display(GLAutoDrawable _drawable) 
    {
        m_GL2 = _drawable.getGL().getGL2();  
        m_GL2.glClearColor(0, 0, 0, 1);        
        m_GL2.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);       
        m_GL2.glLoadIdentity();
        
        //Game Logic
        if(!m_HowToPlay)
        {
            if(!m_Ingame)
                MenuScreen();
            else
            {
                GameScreen();
            }
        }
        else
            HowToPlay();
        
        m_GL2.glFlush();
    }
    
    public void MenuScreen()
    {
        m_Menu.CreateText(-95, 90, "HIGH SCORE:", Color.blue, 25);
        m_Menu.CreateText(-60, 90, Integer.toString(m_Game.GetHighScore()), Color.white, 1);
        m_Menu.CreateText(-20, 30, "TETRIS 1.0", Color.blue, 5);
        m_Menu.CreateText(-15, -50, "Start Game", Color.white, 8);
        m_Menu.CreateText(-15, -60, "How to Play", Color.white, 8);
        m_Menu.CreateText(-15, -70, "Exit", Color.white, 8);
        m_Menu.SelectPoint(m_Selection);
    }
    
    public void GameScreen()
    {
        m_Game.CreateScene();
        m_Game.Execute();
        m_Menu.CreateText(-95, 90, "SCORE:", Color.blue, 25);
        m_Menu.CreateText(-70, 90, Integer.toString(m_Game.GetPoints()), Color.white, 1);
        m_Menu.CreateText(65, 90, "Next Piece", Color.white, 7);
        
        if(m_Game.IsGameOver())
        {
            m_Menu.CreateText(35, -20, "GAME OVER", Color.red, 8);
            m_Menu.CreateText(35, -25, "Press ENTER to return to Main Menu", Color.white, 7);
        }
    }
    
    public void HowToPlay()
    {
        m_Selection = 2;
        m_Menu.CreateText(-50, 0, "HOW TO PLAY", Color.yellow, 8);
        m_Menu.CreateText(-50, -10, "1. Use arrows left and right to move a piece", Color.white, 7);
        m_Menu.CreateText(-50, -15, "2. Complete a line with piece to give 100 points", Color.white, 7);
        m_Menu.CreateText(-50, -20, "3. After complete a line with pieces, this line will be removed", Color.white, 7);
        m_Menu.CreateText(-50, -25, "4. If you place a piece in the out top, you lose", Color.white, 7);
        m_Menu.CreateText(-15, -60, "Back", Color.white, 8);
        m_Menu.SelectPoint(m_Selection);
    }

    @Override
    public void reshape(GLAutoDrawable _drawable, int _x, int _y, int _width, int _height) 
    {
        GL2 m_GL2 = _drawable.getGL().getGL2();        
        m_GL2.glMatrixMode(GL2.GL_PROJECTION);      
        m_GL2.glLoadIdentity();
        m_GL2.glOrtho(-100,100,-100,100,-100,100);
        m_GL2.glMatrixMode(GL2.GL_MODELVIEW);
    }

    @Override
    public void keyPressed(KeyEvent _event) 
    {
        switch(_event.getKeyCode())
        {
            case KeyEvent.VK_ESCAPE:
            	animator.stop();
                System.exit(0);
                break;
                
            case KeyEvent.VK_UP:
                KeyUp();
                break;
                
            case KeyEvent.VK_DOWN:
                KeyDown();
                break;
                
            case KeyEvent.VK_ENTER:
                KeyEnter();
                break;
                
            case KeyEvent.VK_LEFT:
                KeyLeft();
                break;
                
            case KeyEvent.VK_RIGHT:
                KeyRight();
                break;
        }
    }
    
    private void KeyEnter()
    {
        if(!m_Ingame)
        {
            switch(m_Selection)
            {
                case 1:
                    m_Ingame = true;
                    m_Game.NewGame();
                    break;
                case 2:
                    m_HowToPlay = !m_HowToPlay;
                    break;
                case 3:
                	animator.stop();
                    System.exit(0);
                    break;
            }
        }
        
        if(m_Game.IsGameOver())
        {
            m_Ingame = false;
        }
    }
    
    private void KeyLeft()
    {
        if(m_Ingame && !m_Game.IsGameOver())
            m_Game.MoveLeft();
    }
    
    private void KeyRight()
    {
        if(m_Ingame && !m_Game.IsGameOver())
            m_Game.MoveRight();
    }
    
    private void KeyDown() 
    {
        if(m_Selection < 3 && !m_Ingame)
            m_Selection++;
        
        if(m_Ingame && !m_Game.IsGameOver())
            m_Game.FastDropPiece();
    }
    
    private void KeyUp()
    {
        if(m_Selection > 1 && !m_Ingame)
            m_Selection--;
        
        if(m_Ingame && !m_Game.IsGameOver())
            m_Game.RotatePiece();
    }
    
    @Override
    public void keyReleased(KeyEvent _event) 
    {        
        switch(_event.getKeyCode())
        {
            case KeyEvent.VK_DOWN:
                m_Game.NormalDropPiece();
                break;
        }
    }
}