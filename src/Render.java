import com.jogamp.newt.event.WindowAdapter;
import com.jogamp.newt.event.WindowEvent;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.FPSAnimator;

public class Render 
{
    private static GLWindow m_Windows = null;
    private static int m_ScreenWidth = 640;
    private static int m_ScreenHeight = 480;
    
    public static void main(String[] args) 
    {
        GLProfile m_Profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities m_Capabilities = new GLCapabilities(m_Profile);   
        
        m_Windows = GLWindow.create(m_Capabilities);
        m_Windows.setSize(m_ScreenWidth, m_ScreenHeight);
        m_Windows.setResizable(true);
        
        
        Game m_GameScreen = new Game();  //Class for showing menu/game/how to play
        m_Windows.addGLEventListener(m_GameScreen); 
        m_Windows.addKeyListener(m_GameScreen);

        
        FPSAnimator animator = new FPSAnimator(m_Windows, 60);
        animator.start();
        m_GameScreen.setAnimator(animator);
        
        m_Windows.addWindowListener(new WindowAdapter() 
        {
            @Override
            public void windowDestroyNotify(WindowEvent e) 
            {
                animator.stop();
                System.exit(0);
            }
        });   
        
        m_Windows.setFullscreen(false);
        m_Windows.setVisible(true);
    } 
}