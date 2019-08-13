import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.gl2.GLUT;

public class Piece 
{
    private GL2 m_GL2;
    private GLUT m_Glut;
    private int m_PieceRotate;
    
    public Piece(GL2 _openGL2, String _pieceType)
    {
        m_GL2 = _openGL2;
        m_Glut = new GLUT();
        m_PieceRotate = 0;
    }
    
    public void Rotate()
    {
        if(m_PieceRotate >= 270)
            m_PieceRotate = 0;
        else
            m_PieceRotate += 90;
    }
    
    public int GetRotateValue()
    {
        return m_PieceRotate;
    }
    
    public void SetRotateValue(int _value)
    {
        m_PieceRotate = _value;
    }
    
    public void RestartRotate()
    {
        m_PieceRotate = 0;
    }
    
    public void DropPiece(int _posX, int _posY, String _pieceType)
    {
    	switch(_pieceType)
        {
            case "Block":
                DrawBlock(_posX, _posY);
                break;
            case "Quad":
                DrawQuad(_posX, _posY);
                break;
            case "Zl":
                DrawZL(_posX, _posY, false);
                break;
            case "Zr":
                DrawZR(_posX, _posY, false);
                break;
            case "Tower":
                DrawTower(_posX, _posY, false);
                break;
            case "T":
                DrawT(_posX, _posY, false);
                break;
            case "Pl":
                DrawPL(_posX, _posY, false);
                break;
            case "Pr":
                DrawPR(_posX, _posY, false);
                break;
        }
    }
    
    public void DropPiece(int _posX, int _posY, String _pieceType, boolean _onlyDraw)
    {
    	switch(_pieceType)
        {
            case "Block":
                DrawBlock(_posX, _posY);
                break;
            case "Quad":
                DrawQuad(_posX, _posY);
                break;
            case "Zl":
                DrawZL(_posX, _posY, _onlyDraw);
                break;
            case "Zr":
                DrawZR(_posX, _posY, _onlyDraw);
                break;
            case "Tower":
                DrawTower(_posX, _posY, _onlyDraw);
                break;
            case "T":
                DrawT(_posX, _posY, _onlyDraw);
                break;
            case "Pl":
                DrawPL(_posX, _posY, _onlyDraw);
                break;
            case "Pr":
                DrawPR(_posX, _posY, _onlyDraw);
                break;
        }
    }
    
    private void DrawBlock(int _posX, int _posY)
    {
        m_GL2.glPushMatrix();
        m_GL2.glTranslatef(_posX, _posY, 0);
        m_GL2.glColor3f(1, 1, 1);
        m_Glut.glutSolidCube(5);
        m_GL2.glPopMatrix();
    }
    
    private void DrawPL(int _posX, int _posY, boolean _onlyDraw)
    {
        if(_onlyDraw)
        {
            m_GL2.glPushMatrix();
            m_GL2.glTranslatef(_posX, _posY, 0);
            m_GL2.glColor3f(1, 1, 1);
            m_Glut.glutSolidCube(5);
            m_GL2.glPopMatrix();

            m_GL2.glPushMatrix();
            m_GL2.glTranslatef(_posX, _posY + 5, 0);
            m_GL2.glColor3f(1, 1, 1);
            m_Glut.glutSolidCube(5);
            m_GL2.glPopMatrix();

            m_GL2.glPushMatrix();
            m_GL2.glTranslatef(_posX, _posY + 10, 0);
            m_GL2.glColor3f(1, 1, 1);
            m_Glut.glutSolidCube(5);
            m_GL2.glPopMatrix();

            m_GL2.glPushMatrix();
            m_GL2.glTranslatef(_posX - 5, _posY + 10, 0);
            m_GL2.glColor3f(1, 1, 1);
            m_Glut.glutSolidCube(5);
            m_GL2.glPopMatrix();
        }
        else
        {
            switch(m_PieceRotate)
            {
                case 0:
                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX, _posY, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX, _posY + 5, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX, _posY + 10, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX - 5, _posY + 10, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();
                    break;

                case 90:
                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX, _posY, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX + 5, _posY, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX + 10, _posY, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX + 10, _posY + 5, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();
                    break;

                case 180:
                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX, _posY, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX + 5, _posY, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX, _posY + 5, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX, _posY + 10, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();
                    break;

                case 270:
                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX, _posY, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX, _posY + 5, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX + 5, _posY + 5, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX + 10, _posY + 5, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();
                    break;
            }
        }
    }
    
    private void DrawPR(int _posX, int _posY, boolean _onlyDraw)
    {
        if(_onlyDraw)
        {
            m_GL2.glPushMatrix();
            m_GL2.glTranslatef(_posX, _posY, 0);
            m_GL2.glColor3f(1, 1, 1);
            m_Glut.glutSolidCube(5);
            m_GL2.glPopMatrix();

            m_GL2.glPushMatrix();
            m_GL2.glTranslatef(_posX, _posY + 5, 0);
            m_GL2.glColor3f(1, 1, 1);
            m_Glut.glutSolidCube(5);
            m_GL2.glPopMatrix();

            m_GL2.glPushMatrix();
            m_GL2.glTranslatef(_posX, _posY + 10, 0);
            m_GL2.glColor3f(1, 1, 1);
            m_Glut.glutSolidCube(5);
            m_GL2.glPopMatrix();

            m_GL2.glPushMatrix();
            m_GL2.glTranslatef(_posX + 5, _posY + 10, 0);
            m_GL2.glColor3f(1, 1, 1);
            m_Glut.glutSolidCube(5);
            m_GL2.glPopMatrix();
        }
        else
        {
            switch(m_PieceRotate)
            {
                case 0:
                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX, _posY, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX, _posY + 5, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX, _posY + 10, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX + 5, _posY + 10, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();
                    break;

                case 90:
                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX, _posY, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX, _posY + 5, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX - 5, _posY + 5, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX - 10, _posY + 5, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();
                    break;

                case 180:
                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX, _posY, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX + 5, _posY, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX + 5, _posY + 5, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX + 5, _posY + 10, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();
                    break;

                case 270:
                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX, _posY, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX, _posY + 5, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX + 5, _posY, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX + 10, _posY, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();
                    break; 
            }
        }
    }
    
    private void DrawT(int _posX, int _posY, boolean _onlyDraw)
    {
        if(_onlyDraw)
        {
            m_GL2.glPushMatrix();
            m_GL2.glTranslatef(_posX, _posY, 0);
            m_GL2.glColor3f(1, 1, 1);
            m_Glut.glutSolidCube(5);
            m_GL2.glPopMatrix();

            m_GL2.glPushMatrix();
            m_GL2.glTranslatef(_posX, _posY + 5, 0);
            m_GL2.glColor3f(1, 1, 1);
            m_Glut.glutSolidCube(5);
            m_GL2.glPopMatrix();

            m_GL2.glPushMatrix();
            m_GL2.glTranslatef(_posX + 5, _posY + 5, 0);
            m_GL2.glColor3f(1, 1, 1);
            m_Glut.glutSolidCube(5);
            m_GL2.glPopMatrix();

            m_GL2.glPushMatrix();
            m_GL2.glTranslatef(_posX - 5, _posY + 5, 0);
            m_GL2.glColor3f(1, 1, 1);
            m_Glut.glutSolidCube(5);
            m_GL2.glPopMatrix();
        }
        else
        {
            switch(m_PieceRotate)
            {
                case 0:
                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX, _posY, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX, _posY + 5, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX + 5, _posY + 5, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX - 5, _posY + 5, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();
                    break;

                case 90:
                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX, _posY, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX, _posY + 5, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX - 5, _posY + 5, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX, _posY + 10, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();
                    break;

                case 180:
                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX, _posY, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX + 5, _posY, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX + 10, _posY, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX + 5, _posY + 5, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();
                    break;

                case 270:
                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX, _posY, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX, _posY + 5, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX + 5, _posY + 5, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX, _posY + 10, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();
                    break;
            }
        }
    }
    
    private void DrawQuad(int _posX, int _posY)
    {
        m_GL2.glPushMatrix();
        m_GL2.glTranslatef(_posX, _posY, 0);
        m_GL2.glColor3f(1, 1, 1);
        m_Glut.glutSolidCube(5);
        m_GL2.glPopMatrix();
        
        m_GL2.glPushMatrix();
        m_GL2.glTranslatef(_posX + 5, _posY, 0);
        m_GL2.glColor3f(1, 1, 1);
        m_Glut.glutSolidCube(5);
        m_GL2.glPopMatrix();
        
        m_GL2.glPushMatrix();
        m_GL2.glTranslatef(_posX, _posY + 5, 0);
        m_GL2.glColor3f(1, 1, 1);
        m_Glut.glutSolidCube(5);
        m_GL2.glPopMatrix();
        
        m_GL2.glPushMatrix();
        m_GL2.glTranslatef(_posX + 5, _posY + 5, 0);
        m_GL2.glColor3f(1, 1, 1);
        m_Glut.glutSolidCube(5);
        m_GL2.glPopMatrix();
    }
    
    private void DrawZL(int _posX, int _posY, boolean _onlyDraw)
    {
        if(_onlyDraw)
        {
            m_GL2.glPushMatrix();
            m_GL2.glTranslatef(_posX, _posY, 0);
            m_GL2.glColor3f(1, 1, 1);
            m_Glut.glutSolidCube(5);
            m_GL2.glPopMatrix();

            m_GL2.glPushMatrix();
            m_GL2.glTranslatef(_posX + 5, _posY, 0);
            m_GL2.glColor3f(1, 1, 1);
            m_Glut.glutSolidCube(5);
            m_GL2.glPopMatrix();

            m_GL2.glPushMatrix();
            m_GL2.glTranslatef(_posX, _posY + 5, 0);
            m_GL2.glColor3f(1, 1, 1);
            m_Glut.glutSolidCube(5);
            m_GL2.glPopMatrix();

            m_GL2.glPushMatrix();
            m_GL2.glTranslatef(_posX - 5, _posY + 5, 0);
            m_GL2.glColor3f(1, 1, 1);
            m_Glut.glutSolidCube(5);
            m_GL2.glPopMatrix();
        }
        else
        {
            switch(m_PieceRotate)
            {
                case 90:
                case 270:
                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX, _posY, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX, _posY + 5, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX + 5, _posY + 5, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX + 5, _posY + 10, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();
                    break;

                default:
                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX, _posY, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX + 5, _posY, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX, _posY + 5, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX - 5, _posY + 5, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();
                    break;
            }
        }
    }
    
    private void DrawZR(int _posX, int _posY, boolean _onlyDraw)
    {
        if(_onlyDraw)
        {
            m_GL2.glPushMatrix();
            m_GL2.glTranslatef(_posX, _posY, 0);
            m_GL2.glColor3f(1, 1, 1);
            m_Glut.glutSolidCube(5);
            m_GL2.glPopMatrix();

            m_GL2.glPushMatrix();
            m_GL2.glTranslatef(_posX + 5, _posY, 0);
            m_GL2.glColor3f(1, 1, 1);
            m_Glut.glutSolidCube(5);
            m_GL2.glPopMatrix();

            m_GL2.glPushMatrix();
            m_GL2.glTranslatef(_posX + 5, _posY + 5, 0);
            m_GL2.glColor3f(1, 1, 1);
            m_Glut.glutSolidCube(5);
            m_GL2.glPopMatrix();

            m_GL2.glPushMatrix();
            m_GL2.glTranslatef(_posX + 10, _posY + 5, 0);
            m_GL2.glColor3f(1, 1, 1);
            m_Glut.glutSolidCube(5);
            m_GL2.glPopMatrix();
        }
        else
        {
            switch(m_PieceRotate)
            {
                case 90:
                case 270:
                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX, _posY, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX, _posY + 5, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX - 5, _posY + 5, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX - 5, _posY + 10, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();
                    break;

                default:
                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX, _posY, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX + 5, _posY, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX + 5, _posY + 5, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX + 10, _posY + 5, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();
                    break;
            }
        }
    }
    
    private void DrawTower(int _posX, int _posY, boolean _onlyDraw)
    {
        if(_onlyDraw)
        {
            m_GL2.glPushMatrix();
            m_GL2.glTranslatef(_posX, _posY, 0);
            m_GL2.glColor3f(1, 1, 1);
            m_Glut.glutSolidCube(5);
            m_GL2.glPopMatrix();

            m_GL2.glPushMatrix();
            m_GL2.glTranslatef(_posX, _posY + 5, 0);
            m_GL2.glColor3f(1, 1, 1);
            m_Glut.glutSolidCube(5);
            m_GL2.glPopMatrix();

            m_GL2.glPushMatrix();
            m_GL2.glTranslatef(_posX, _posY + 10, 0);
            m_GL2.glColor3f(1, 1, 1);
            m_Glut.glutSolidCube(5);
            m_GL2.glPopMatrix();

            m_GL2.glPushMatrix();
            m_GL2.glTranslatef(_posX, _posY + 15, 0);
            m_GL2.glColor3f(1, 1, 1);
            m_Glut.glutSolidCube(5);
            m_GL2.glPopMatrix();
        }
        else
        {
            switch(m_PieceRotate)
            {
                case 90:
                case 270:
                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX, _posY, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX + 5, _posY, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX + 10, _posY, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX + 15, _posY, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();
                    break;

                default:
                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX, _posY, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX, _posY + 5, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX, _posY + 10, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();

                    m_GL2.glPushMatrix();
                    m_GL2.glTranslatef(_posX, _posY + 15, 0);
                    m_GL2.glColor3f(1, 1, 1);
                    m_Glut.glutSolidCube(5);
                    m_GL2.glPopMatrix();
                    break;
            }
        }
    }
    
    /*Oboji u zavisnosti od elementa u odredjenu boju*/
    public void DrawPieceInBoard(int[][] _board)
    {
        for(int x = 0; x < _board.length; x++)
        {
            for(int y = 0; y < _board[x].length; y++)
            {
                switch(_board[x][y])
                {
                    case 1:
                        AddPieceInBoard(GetBoardPos(x, y)[0], GetBoardPos(x, y)[1], 0, 1, 0);
                        break;
                    case 2:
                        AddPieceInBoard(GetBoardPos(x, y)[0], GetBoardPos(x, y)[1], 1, 0, 0);
                        break;
                    case 3:
                        AddPieceInBoard(GetBoardPos(x, y)[0], GetBoardPos(x, y)[1], 0, 0, 1);
                        break;
                    case 4:
                        AddPieceInBoard(GetBoardPos(x, y)[0], GetBoardPos(x, y)[1], 1, 1, 0);
                        break;
                    case 5:
                        AddPieceInBoard(GetBoardPos(x, y)[0], GetBoardPos(x, y)[1], 0, 1, 1);
                        break;
                    case 6:
                        AddPieceInBoard(GetBoardPos(x, y)[0], GetBoardPos(x, y)[1], 1, 0, 1);
                        break;
                    case 7:
                        AddPieceInBoard(GetBoardPos(x, y)[0], GetBoardPos(x, y)[1], 0.80f, 0.66f, 0.49f);
                        break;
                    case 8:
                        AddPieceInBoard(GetBoardPos(x, y)[0], GetBoardPos(x, y)[1], 1f, 0.75f, 0.80f);
                        break;
                }
            }
        }
    }
    
    /*Oboji kvadratic u odredjenu boju*/
    private void AddPieceInBoard(int _posX, int _posY, float _R, float _G, float _B)
    {
        m_GL2.glPushMatrix();
        m_GL2.glTranslatef(_posX, _posY, 0);
        m_GL2.glColor3f(_R, _G, _B);
        m_Glut.glutSolidCube(5);
        m_GL2.glPopMatrix();
    }
    
    /*Pozicija gde treba da se nacrta kvadratic*/
    private int[] GetBoardPos(int _posX, int _posY)
    {
        int pos [] = new int[2];
        
        pos[0] = -20 + _posX * 5;
        pos[1] = 45 - _posY * 5;
        
        return pos;
    }
}
