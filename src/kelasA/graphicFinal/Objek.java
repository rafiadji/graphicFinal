/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelasA.graphicFinal;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

/**
 *
 * @author RafiAdji
 */
public class Objek {

    static void Lapangan(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        double PI = 3.141592653589793;
        int i, radius, jumlah_titik, x_tengah, y_tengah;

        //lapangan
        gl.glBegin(GL.GL_POLYGON);  //  atas
        gl.glColor3f(0f, 1f, 0f);
        gl.glVertex3f(-6.5f, 0.5f, 0.0f);
        gl.glVertex3f(-6.5f, 0.5f, -3.0f);
        gl.glVertex3f(-6.5f, 0.5f, 3.0f);
        gl.glVertex3f(6.5f, 0.5f, 3.0f);
        gl.glVertex3f(6.5f, 0.5f, -3.0f);
        gl.glVertex3f(-6.5f, 0.5f, -3.0f);
        gl.glEnd();

        gl.glBegin(GL.GL_POLYGON);  //  bawah
        gl.glColor3f(0f, 1f, 0f);
        gl.glVertex3f(-6.5f, 0.0f, 0.0f);
        gl.glVertex3f(-6.5f, 0.0f, -3.0f);
        gl.glVertex3f(-6.5f, 0.0f, 3.0f);
        gl.glVertex3f(6.5f, 0.0f, 3.0f);
        gl.glVertex3f(6.5f, 0.0f, -3.0f);
        gl.glVertex3f(-6.5f, 0.0f, -3.0f);
        gl.glEnd();
//  
        gl.glBegin(GL.GL_POLYGON); //samping kiri
        gl.glColor3f(0f, 1f, 0f);
        gl.glVertex3f(-6.5f, 0.5f, 0.0f);
        gl.glVertex3f(-6.5f, 0.5f, -3.0f);
        gl.glVertex3f(-6.5f, 0.5f, 3.0f);
        gl.glVertex3f(-6.5f, 0.0f, 3.0f);
        gl.glVertex3f(-6.5f, 0.0f, 3.0f);
        gl.glVertex3f(-6.5f, 0.0f, -3.0f);
        gl.glVertex3f(-6.5f, 0.5f, -3.0f);
        gl.glEnd();

        gl.glBegin(GL.GL_POLYGON); //samping kanan
        gl.glColor3f(0f, 1f, 0f);
        gl.glVertex3f(6.5f, 0.5f, 0.0f);
        gl.glVertex3f(6.5f, 0.5f, -3.0f);
        gl.glVertex3f(6.5f, 0.5f, 3.0f);
        gl.glVertex3f(6.5f, 0.0f, 3.0f);
        gl.glVertex3f(6.5f, 0.0f, 3.0f);
        gl.glVertex3f(6.5f, 0.0f, -3.0f);
        gl.glVertex3f(6.5f, 0.5f, -3.0f);
        gl.glEnd();
//  
//  
        gl.glBegin(GL.GL_POLYGON); //samping belakang
        gl.glColor3f(0f, 1f, 0f);
        gl.glVertex3f(-6.5f, 0.5f, 0.0f);
        gl.glVertex3f(6.5f, 0.5f, 0.0f);
        gl.glVertex3f(6.5f, 0.0f, 0.0f);
        gl.glVertex3f(-6.5f, 0.0f, 0.0f);
        gl.glVertex3f(-6.5f, 0.5f, 0.0f);
        gl.glEnd();

        gl.glBegin(GL.GL_POLYGON); //samping depan
        gl.glColor3f(0f, 1f, 0f);
        gl.glVertex3f(-6.5f, 0.0f, -3.0f);
        gl.glVertex3f(-6.5f, 0.5f, -3.0f);
        gl.glVertex3f(6.5f, 0.5f, -3.0f);
        gl.glVertex3f(6.5f, 0.0f, -3.0f);
        gl.glVertex3f(-6.5f, 0.0f, -3.0f);
        gl.glVertex3f(-6.5f, 0.5f, -3.0f);
        gl.glEnd();

        //   garis samping lapangan
        gl.glBegin(GL.GL_LINE_STRIP);
        gl.glColor3f(1f, 1f, 1f);
        gl.glVertex3f(-6.0f, -0.1f, -2.30f);
        gl.glVertex3f(-6.0f, -0.1f, -2.30f);
        gl.glVertex3f(-6.0f, -0.1f, 0.0f);
        gl.glVertex3f(-6.0f, -0.1f, 2.30f);
        gl.glVertex3f(0.0f, -0.1f, 2.30f);
        gl.glVertex3f(6.0f, -0.1f, 2.30f);
        gl.glVertex3f(6.0f, -0.1f, -2.30f);
        gl.glVertex3f(-6.0f, -0.1f, -2.30f);
        gl.glEnd();

        //garis kotak penalti kiri
        gl.glBegin(GL.GL_LINE_STRIP);
        gl.glColor3f(1f, 1f, 1f);
        gl.glVertex3f(-6.0f, -0.1f, -1.5f);
        gl.glVertex3f(-6.0f, -0.1f, -1.5f);
        gl.glVertex3f(-6.0f, -0.1f, 0.0f);
        gl.glVertex3f(-6.0f, -0.1f, 1.5f);
        gl.glVertex3f(-4.5f, -0.1f, 1.5f);
        gl.glVertex3f(-4.5f, -0.1f, -1.5f);
        gl.glVertex3f(-6.0f, -0.1f, -1.5f);
        gl.glEnd();

        gl.glBegin(GL.GL_LINE_STRIP);
        gl.glColor3f(1f, 1f, 1f);
        gl.glVertex3f(-6.0f, -0.1f, -0.8f);
        gl.glVertex3f(-6.0f, -0.1f, -0.8f);
        gl.glVertex3f(-6.0f, -0.1f, 0.0f);
        gl.glVertex3f(-6.0f, -0.1f, 0.8f);
        gl.glVertex3f(-5.5f, -0.1f, 0.8f);
        gl.glVertex3f(-5.5f, -0.1f, -0.8f);
        gl.glVertex3f(-6.0f, -0.1f, -0.8f);
        gl.glEnd();

        //titik putih sebelah kiri
        gl.glPointSize(4.0f);  //menentukan ukuran titik
        gl.glBegin(GL.GL_POINTS);
        gl.glVertex3f(-5.0f, -0.1f, 0.0f);
        gl.glEnd();

        //titik putih sebelah kanan
        gl.glPointSize(4.0f);  //menentukan ukuran titik
        gl.glBegin(GL.GL_POINTS);
        gl.glVertex3f(5.0f, -0.1f, 0.0f);
        gl.glEnd();

        //garis kotak penalti sebelah kanan
        gl.glLineWidth(3.0f);
        gl.glBegin(GL.GL_LINE_STRIP);
        gl.glColor3f(1f, 1f, 1f);
        gl.glVertex3f(6.0f, -0.1f, -1.5f);
        gl.glVertex3f(6.0f, -0.1f, -1.5f);
        gl.glVertex3f(6.0f, -0.1f, 0.0f);
        gl.glVertex3f(6.0f, -0.1f, 1.5f);
        gl.glVertex3f(4.5f, -0.1f, 1.5f);
        gl.glVertex3f(4.5f, -0.1f, -1.5f);
        gl.glVertex3f(6.0f, -0.1f, -1.5f);
        gl.glEnd();

        gl.glBegin(GL.GL_LINE_STRIP);
        gl.glColor3f(1f, 1f, 1f);
        gl.glVertex3f(6.0f, -0.1f, -0.8f);
        gl.glVertex3f(6.0f, -0.1f, -0.8f);
        gl.glVertex3f(6.0f, -0.1f, 0.0f);
        gl.glVertex3f(6.0f, -0.1f, 0.8f);
        gl.glVertex3f(5.5f, -0.1f, 0.8f);
        gl.glVertex3f(5.5f, -0.1f, -0.8f);
        gl.glVertex3f(6.0f, -0.1f, -0.8f);
        gl.glEnd();

        //garis tengah lapangan
        gl.glBegin(GL.GL_LINE_STRIP);
        gl.glColor3f(1f, 1f, 1f);
        gl.glVertex3f(0.0f, -0.1f, 2.30f);
        gl.glVertex3f(0.0f, -0.1f, -2.30f);
        gl.glVertex3f(0.0f, -0.1f, 2.30f);

        gl.glEnd();

        //lingkaran tengah lapangan
        gl.glRotatef(-90, 1, 0, 0);
        gl.glBegin(GL.GL_LINE_LOOP);
        gl.glColor3f(1f, 1f, 1f);

        radius = 80;
        jumlah_titik = 40;
        x_tengah = 0;
        y_tengah = 0;
        for (i = 0; i <= 360; i++) {
            float sudut = (float) (i * (2 * PI / jumlah_titik));
            float x = (float) (x_tengah + radius * cos(sudut));
            float y = (float) (y_tengah + radius * sin(sudut));
            gl.glVertex3f(x / 100, y / 100, 0);

        }
        gl.glEnd();

        //titik tengah lapangan
        gl.glPointSize(3.0f);  //menentukan ukuran titik
        gl.glBegin(GL.GL_POINTS);
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glEnd();

    }
    
    
    static void Pemain(GL gl, GLU glu, int tipe) {
        if(tipe == 1){
            gl.glColor3f(0.91f, 0.99f, 0);
        }else if(tipe == 2){
            gl.glColor3f(0.17f, 0.65f, 0.11f);
        }else if(tipe == 3){
            gl.glColor3f(0.05f, 0.34f, 0.7f);
        }else if(tipe == 4){
            gl.glColor3f(0.82f, 0.01f, 0.01f);
        }
        //badan
        float BODY_LENGTH = 0.35f;
        float BODY_RADIUS = 0.2f;
        float BODY_RADIUS1 = 0.0f;

        int SLICES = 30;
        int STACKS = 30;
        GLUquadric q = glu.gluNewQuadric();

        gl.glRotatef(270, 1.0f, 0.0f, 0.0f);
        glu.gluCylinder(q, BODY_RADIUS1, BODY_RADIUS,BODY_LENGTH, SLICES, STACKS);
        gl.glTranslatef(0.0f, 0.0f, BODY_LENGTH);
        glu.gluDisk(q, 0.0f, BODY_RADIUS, SLICES, STACKS); 
        
        //kepala
        gl.glRotatef(180, 1.0f, 0.0f, 0.0f);
        double clip_plane1[] = {0.0, 0.0, -1.0, 0.0};
        gl.glClipPlane(GL.GL_CLIP_PLANE1, clip_plane1, 0);
        gl.glEnable(GL.GL_CLIP_PLANE1);
        // drawing a sphere
        GLUquadric qd = glu.gluNewQuadric();
        glu.gluSphere(qd, 0.2f, 60, 60);
        glu.gluDeleteQuadric(qd);
        gl.glDisable(GL.GL_CLIP_PLANE1);
        glu.gluDisk(qd, 0.0f, 0.2f, 60, 60);

    }
}
