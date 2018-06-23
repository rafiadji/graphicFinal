package kelasA.graphicFinal;

import com.sun.opengl.util.Animator;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

/**
 * GraphicFinal.java <BR>
 * author:  Ninda Zulistyaningsih
 *          M Tegar Maha Putra 
 *          Rafi Pratama Adji
 */
public class GraphicFinal implements GLEventListener {

    float angle = 0;

    public static void main(String[] args) {
        Frame frame = new Frame("TA Grafis");
        GLCanvas canvas = new GLCanvas();

        canvas.addGLEventListener(new GraphicFinal());
        frame.add(canvas);
        frame.setSize(640, 480);
        final Animator animator = new Animator(canvas);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                new Thread(new Runnable() {

                    public void run() {
                        animator.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        animator.start();
    }

    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        System.err.println("INIT GL IS: " + gl.getClass().getName());

        gl.setSwapInterval(1);

        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glShadeModel(GL.GL_SMOOTH);
//        gl.glShadeModel(GL.GL_3D_COLOR);
//        gl.glEnable(GL.GL_LIGHTING);
//        gl.glEnable(GL.GL_LIGHT0);
        gl.glEnable(GL.GL_COLOR_MATERIAL);
        gl.glEnable(GL.GL_DEPTH_TEST);
        gl.glDepthFunc(GL.GL_LEQUAL);
//        gl.glEnable(GL.GL_NORMALIZE);
        gl.glHint(GL.GL_PERSPECTIVE_CORRECTION_HINT, GL.GL_NICEST);
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();

        if (height <= 0) {
            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();
        angle += 0.5;
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
    
        gl.glTranslatef(0.0f, 0.0f, -15.0f);
        gl.glRotatef(-145, 1, 0, 0);
//        gl.glRotatef(angle, 1, 0, 0);
        gl.glPushMatrix();
        Objek.Lapangan(drawable);
        Objek.Pemain(gl, glu, 4);
        gl.glPopMatrix();
        

        gl.glFlush();
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }
}
