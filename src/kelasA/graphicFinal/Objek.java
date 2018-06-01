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
        gl.glBegin(GL.GL_POLYGON);
        gl.glColor3f(0f, 1f, 0f);
        gl.glVertex3f(-6.5f, -3.0f, 0.0f);
        gl.glVertex3f(-6.5f, 0.0f, 0.0f);
        gl.glVertex3f(-6.5f, 3.0f, 0.0f);
        gl.glVertex3f(0.0f, 3.0f, 0.0f);
        gl.glVertex3f(6.5f, 3.0f, 0.0f);
        gl.glVertex3f(6.5f, -3.0f, 0.0f);

        gl.glEnd();

        gl.glBegin(GL.GL_POLYGON);
        gl.glColor3f(0f, 1f, 0.1f);
        gl.glVertex3f(-3.8f, -3.0f, 0.0f);
        gl.glVertex3f(-3.8f, 0.0f, 0.0f);
        gl.glVertex3f(-3.8f, 3.0f, 0.0f);
        gl.glVertex3f(-1.5f, 3.0f, 0.0f);
        gl.glVertex3f(-1.5f, -3.0f, 0.0f);

        gl.glEnd();

        gl.glBegin(GL.GL_POLYGON);
        gl.glColor3f(0f, 1f, 0.1f);
        gl.glVertex3f(3.8f, -3.0f, 0.0f);
        gl.glVertex3f(3.8f, 0.0f, 0.0f);
        gl.glVertex3f(3.8f, 3.0f, 0.0f);
        gl.glVertex3f(1.5f, 3.0f, 0.0f);
        gl.glVertex3f(1.5f, -3.0f, 0.0f);

        gl.glEnd();

        //garis samping lapangan
        gl.glBegin(GL.GL_LINE_STRIP);
        gl.glColor3f(1f, 1f, 1f);
        gl.glVertex3f(-6.0f, -2.30f, 0.0f);
        gl.glVertex3f(-6.0f, -2.30f, 0.0f);
        gl.glVertex3f(-6.0f, 0.0f, 0.0f);
        gl.glVertex3f(-6.0f, 2.30f, 0.0f);
        gl.glVertex3f(0.0f, 2.30f, 0.0f);
        gl.glVertex3f(6.0f, 2.30f, 0.0f);
        gl.glVertex3f(6.0f, -2.30f, 0.0f);
        gl.glVertex3f(-6.0f, -2.30f, 0.0f);
        gl.glEnd();

        //garis kotak penalti kiri
        gl.glBegin(GL.GL_LINE_STRIP);
        gl.glColor3f(1f, 1f, 1f);
        gl.glVertex3f(-6.0f, -1.5f, 0.0f);
        gl.glVertex3f(-6.0f, -1.5f, 0.0f);
        gl.glVertex3f(-6.0f, 0.0f, 0.0f);
        gl.glVertex3f(-6.0f, 1.5f, 0.0f);
        gl.glVertex3f(-4.5f, 1.5f, 0.0f);
        gl.glVertex3f(-4.5f, -1.5f, 0.0f);
        gl.glVertex3f(-6.0f, -1.5f, 0.0f);
        gl.glEnd();

        gl.glBegin(GL.GL_LINE_STRIP);
        gl.glColor3f(1f, 1f, 1f);
        gl.glVertex3f(-6.0f, -0.8f, 0.0f);
        gl.glVertex3f(-6.0f, -0.8f, 0.0f);
        gl.glVertex3f(-6.0f, 0.0f, 0.0f);
        gl.glVertex3f(-6.0f, 0.8f, 0.0f);
        gl.glVertex3f(-5.5f, 0.8f, 0.0f);
        gl.glVertex3f(-5.5f, -0.8f, 0.0f);
        gl.glVertex3f(-6.0f, -0.8f, 0.0f);
        gl.glEnd();

        //titik putih sebelah kiri
        gl.glPointSize(3.0f);  //menentukan ukuran titik
        gl.glBegin(GL.GL_POINTS);
        gl.glVertex3f(-5.0f, 0.0f, 0.0f);
        gl.glEnd();

        //titik putih sebelah kanan
        gl.glPointSize(3.0f);  //menentukan ukuran titik
        gl.glBegin(GL.GL_POINTS);
        gl.glVertex3f(5.0f, 0.0f, 0.0f);
        gl.glEnd();

        //garis kotak penalti sebelah kanan
        gl.glBegin(GL.GL_LINE_STRIP);
        gl.glColor3f(1f, 1f, 1f);
        gl.glVertex3f(6.0f, -1.5f, 0.0f);
        gl.glVertex3f(6.0f, -1.5f, 0.0f);
        gl.glVertex3f(6.0f, 0.0f, 0.0f);
        gl.glVertex3f(6.0f, 1.5f, 0.0f);
        gl.glVertex3f(4.5f, 1.5f, 0.0f);
        gl.glVertex3f(4.5f, -1.5f, 0.0f);
        gl.glVertex3f(6.0f, -1.5f, 0.0f);
        gl.glEnd();

        gl.glBegin(GL.GL_LINE_STRIP);
        gl.glColor3f(1f, 1f, 1f);
        gl.glVertex3f(6.0f, -0.8f, 0.0f);
        gl.glVertex3f(6.0f, -0.8f, 0.0f);
        gl.glVertex3f(6.0f, 0.0f, 0.0f);
        gl.glVertex3f(6.0f, 0.8f, 0.0f);
        gl.glVertex3f(5.5f, 0.8f, 0.0f);
        gl.glVertex3f(5.5f, -0.8f, 0.0f);
        gl.glVertex3f(6.0f, -0.8f, 0.0f);
        gl.glEnd();



        //garis tengah lapangan
        gl.glBegin(GL.GL_LINE_STRIP);
        gl.glColor3f(1f, 1f, 1f);
        gl.glVertex3f(0.0f, 2.30f, 0.0f);
        gl.glVertex3f(0.0f, -2.30f, 0.0f);
        gl.glVertex3f(0.0f, 2.30f, 0.0f);

        gl.glEnd();

        //lingkaran tengah lapangan
        gl.glBegin(GL.GL_LINE_LOOP);
        gl.glColor3f(1f, 1f, 1f);

        radius = 80;
        jumlah_titik = 20;
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

}
