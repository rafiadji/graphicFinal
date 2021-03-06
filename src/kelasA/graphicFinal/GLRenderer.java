/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelasA.graphicFinal;

import java.text.DecimalFormat;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

public class GLRenderer implements GLEventListener {

    float angle = 0;
    float direction = 0;

    class vector {

        float x;
        float y;
        float z;

        public vector(float startX, float startY, float startZ) {
            x = startX;
            y = startY;
            z = startZ;
        }

        void vectorRotation(vector reference, float angle) {
            vector temp = reference;
            float magnitude
                    = (float) Math.sqrt(Math.pow(temp.x, 2) + Math.pow(temp.y,
                                    2) + Math.pow(temp.z, 2));
            temp.x = temp.x / magnitude;
            temp.y
                    = temp.y / magnitude;
            temp.z = temp.z / magnitude;
            float dot_product
                    = (x * temp.x) + (y * temp.y) + (z * temp.z);
            float cross_product_x = (y * temp.z)
                    - (temp.z * z);
            float cross_product_y = -((x * temp.z)
                    - (z * temp.x));
            float cross_product_z = (x * temp.y)
                    - (y * temp.x);
            float last_factor_rodrigues = (float) (1
                    - Math.cos(Math.toRadians(angle % 360)));

            x = (float) ((x * Math.cos(Math.toRadians(angle % 360)))
                    + (cross_product_x * Math.sin(Math.toRadians(angle % 360)))
                    + (dot_product * last_factor_rodrigues * x));

            y = (float) ((this.y * Math.cos(Math.toRadians(angle % 360)))
                    + (cross_product_y * Math.sin(Math.toRadians(angle % 360)))
                    + (dot_product * last_factor_rodrigues * y));

            z = (float) ((z * Math.cos(Math.toRadians(angle % 360)))
                    + (cross_product_z * Math.sin(Math.toRadians(angle % 360)))
                    + (dot_product * last_factor_rodrigues * z));

        }

    }

    vector depanBelakang = new vector(0f, 0f, -1f);//deklarasi awal vektor untuk maju & mundur
    vector samping = new vector(1f, 0f, 0f);//deklarasi awal vektor untuk gerakan ke kanan & kiri
    vector vertikal = new vector(0f, 1f, 0f);//deklarasi awal vetor untuk gerakan naik & turun
    float Cx = 0, Cy = 10.5f, Cz = -4.0f;
    float Lx = 0, Ly = -5.5f, Lz = -24f;
    float angle_depanBelakang = 0f;
    float angle_depanBelakang2 = 0f;
    float angle_samping = 0f;
    float angle_samping2 = 0f;
    float angle_vertikal = 0f;
    float angle_vertikal2 = 0f;
    float formasi2 = -180f;
    boolean ori = true, formasiawal = false, formasimenyerang = false, formasibertahan = false, kamera = false, kamera2 = false;
    vector Sumbu_z = new vector(0f, 0f, -1f);//deklarasi awal vektor untuk maju & mundur
    vector Sumbu_x = new vector(1f, 0f, 0f);//deklarasi awal vektor untuk gerakan ke kanan & kiri
    vector Sumbu_y = new vector(0f, 1f, 0f);//deklarasi awal vetor untuk gerakan naik & turun
    float sudut_x = 0f;
    float sudut_x2 = 0f;

    float sudut_z = 0f;
    float sudut_z2 = 0f;

    float sudut_y = 0f;
    float sudut_y2 = 0f;

    private void vectorMovement(vector toMove, float magnitude, float direction) {
        float speedX = toMove.x * magnitude * direction;
        float speedY = toMove.y * magnitude * direction;
        float speedZ = toMove.z * magnitude * direction;

        Cx += speedX;
        Cy += speedY;
        Cz += speedZ;

        Lx += speedX;
        Ly += speedY;
        Lz += speedZ;
    }

    private void cameraRotation(vector reference, double angle) {
        float M = (float) (Math.sqrt(Math.pow(reference.x, 2) + Math.pow(reference.y,
                2) + Math.pow(reference.z, 2)));

        float Up_x1 = reference.x / M;
        float Up_y1 = reference.y / M;
        float Up_z1 = reference.z / M;

        float VLx = Lx - Cx;
        float VLy = Ly - Cy;
        float VLz = Lz - Cz;
        float dot_product = (VLx * Up_x1) + (VLy * Up_y1) + (VLz * Up_z1);
        float cross_product_x = (Up_y1 * VLz) - (VLy * Up_z1);
        float cross_product_y = -((Up_x1 * VLz) - (Up_z1 * VLx));
        float cross_product_z = (Up_x1 * VLy) - (Up_y1 * VLx);

        float last_factor_rodriques = (float) (1 - Math.cos(Math.toRadians(angle)));

        float Lx1 = (float) ((VLx * Math.cos(Math.toRadians(angle)))
                + (cross_product_x * Math.sin(Math.toRadians(angle)))
                + (dot_product * last_factor_rodriques * VLx));

        float Ly1 = (float) ((VLy * Math.cos(Math.toRadians(angle)))
                + (cross_product_y * Math.sin(Math.toRadians(angle)))
                + (dot_product * last_factor_rodriques * VLy));

        float Lz1 = (float) ((VLz * Math.cos(Math.toRadians(angle)))
                + (cross_product_z * Math.sin(Math.toRadians(angle)))
                + (dot_product * last_factor_rodriques * VLz));

        Lx = Lx1 + Cx;
        Ly = Ly1 + Cy;
        Lz = Lz1 + Cz;
    }

    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        System.err.println("INIT GL IS: " + gl.getClass().getName());

        gl.setSwapInterval(1);

        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
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

    public void reshape(GLAutoDrawable drawable, int x,
            int y, int width, int height) {
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

    float[][] awal = {
        {-5.5f, 0f, 0f, 1},
        {-3f, 0f, 1.8f, 2},
        {-4.0f, 0f, 0.8f, 2},
        {-3.3f, 0f, 0f, 2},
        {-4.0f, 0f, -0.8f, 2},
        {-3f, 0f, -1.8f, 2},
        {0f, 0f, 0.5f, 3},
        {0f, 0f, -0.5f, 3},
        {3.0f, 0f, -1.8f, 3},
        {3.0f, 0f, 1.8f, 3},
        {4.0f, 0f, 0f, 4}
    };

    float[][] menyerang = {
        {-5.5f, 0f, 0f, 1},
        {-4.0f, 0f, 1.3f, 2},
        {-4.0f, 0f, 0f, 2},
        {-4.0f, 0f, -1.3f, 2},
        {0f, 0f, 0.7f, 3},
        {0f, 0f, -0.7f, 3},
        {2.3f, 0f, 1.8f, 3},
        {2.3f, 0f, -1.8f, 3},
        {4.4f, 0f, 1.8f, 4},
        {4.4f, 0f, -1.8f, 4},
        {5f, 0f, 0f, 4}
    };

    float[][] bertahan = {
        {-5.5f, 0f, 0f, 1},
        {-3.6f, 0f, 1.8f, 2},
        {-4.0f, 0f, 0.8f, 2},
        {-4.0f, 0f, 0f, 2},
        {-4.0f, 0f, -0.8f, 2},
        {-3.6f, 0f, -1.8f, 2},
        {-1.4f, 0f, -1.4f, 3},
        {-1.4f, 0f, -0.7f, 3},
        {-1.4f, 0f, 0.7f, 3},
        {-1.4f, 0f, 1.4f, 3},
        {1.4f, 0f, 0f, 4}
    };

    float from[][] = awal, to[][];

    float form[][] = {
        {0f, 0f, 0f, 1},
        {0f, 0f, 0f, 1},
        {0f, 0f, 0f, 1},
        {0f, 0f, 0f, 1},
        {0f, 0f, 0f, 1},
        {0f, 0f, 0f, 1},
        {0f, 0f, 0f, 1},
        {0f, 0f, 0f, 1},
        {0f, 0f, 0f, 1},
        {0f, 0f, 0f, 1},
        {0f, 0f, 0f, 1}
    };

    DecimalFormat df = new DecimalFormat("#.#");

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();

        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        glu.gluLookAt(Cx, Cy, Cz,
                Lx, Ly, Lz,
                vertikal.x, vertikal.y, vertikal.z);

        gl.glTranslatef(0.0f, 3.0f, -15.0f);
        gl.glRotatef(-180, 0, 0, 1);
        gl.glRotatef(formasi2, 0, 1, 0);
        for (int i = 0; i <= 11; i++) {
            gl.glPushMatrix();
        }
        Objek.Lapangan(drawable);

        if (formasimenyerang) {
            to = menyerang;
        } else if (formasibertahan) {
            to = bertahan;
        } else {
            to = awal;
        }
        form = from;
        if (from == to) {
            System.out.println("sama");
            from = to;
        } else {

            for (int i = 0; i < to.length; i++) {
                if (form[i][0] > to[i][0]) {
                    form[i][0] -= 0.1;
                    form[i][0] = Float.parseFloat(df.format(form[i][0]));
                } else if (form[i][0] < to[i][0]) {
                    form[i][0] += 0.1;
                    form[i][0] = Float.parseFloat(df.format(form[i][0]));
                } else {
                    form[i][0] = to[i][0];
                }

                if (form[i][1] > to[i][1]) {
                    form[i][1] -= 0.1;
                    form[i][1] = Float.parseFloat(df.format(form[i][1]));
                } else if (form[i][1] < to[i][1]) {
                    form[i][1] += 0.1;
                    form[i][1] = Float.parseFloat(df.format(form[i][1]));
                } else {
                    form[i][1] = to[i][1];
                }

                if (form[i][2] > to[i][2]) {
                    form[i][2] -= 0.1;
                    form[i][2] = Float.parseFloat(df.format(form[i][2]));
                } else if (form[i][2] < to[i][2]) {
                    form[i][2] += 0.1;
                    form[i][2] = Float.parseFloat(df.format(form[i][2]));
                } else {
                    form[i][2] = to[i][2];
                }

                form[i][3] = to[i][3];
            }
        }
//        for (int i = 0; i < to.length; i++) {
//            System.out.println(from[i][0] + " " + from[i][1] + " " + from[i][2] + " " + from[i][3]);
//        }
        setPemain(form, gl, glu);
        gl.glFlush();
    }

    void setPemain(float[][] form, GL gl, GLU glu) {
        for (int i = 0; i < form.length; i++) {
//            System.out.println(form[i][0] + " " + form[i][1] + " " + form[i][2] + " " + form[i][3]);
            gl.glPopMatrix();
            gl.glTranslatef(form[i][0], form[i][1], form[i][2]);
            gl.glRotatef(180, 1, 0, 0);
            Objek.Pemain(gl, glu, form[i][3]);
        }
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

    void Key_Pressed(int keyCode) {

        if (keyCode == 50) { //tombol 2
            if (formasiawal) {
                formasiawal = false;
            } else {
                formasiawal = true;
                formasibertahan = false;
                formasimenyerang = false;
            }
        } else if (keyCode == 51) { //tombol 3
            if (formasimenyerang) {
                formasimenyerang = false;
            } else {
                formasimenyerang = true;
                formasibertahan = false;
                formasiawal = false;
            }
        } else if (keyCode == 52) { //tombol 4
            if (formasibertahan) {
                formasibertahan = false;
            } else {
                formasibertahan = true;
                formasimenyerang = false;
                formasiawal = false;
            }
        }

        if (keyCode == 87) { // tombol W
            vectorMovement(Sumbu_z, 2f, 1f);
        } else if (keyCode == 83) { // tombol S
            vectorMovement(Sumbu_z, 2f, -1f);
        } else if (keyCode == 68) { // tombol D
            vectorMovement(Sumbu_x, 2f, 1f);
        } else if (keyCode == 65) { // tombol A
            vectorMovement(Sumbu_x, 2f, -1f);
        } else if (keyCode == 38) { // tombol arah  atas
            vectorMovement(Sumbu_y, 2f, 1f);
        } else if (keyCode == 40) { // tombol arah bawah
            vectorMovement(Sumbu_y, 2f, -1f);
        } else if (keyCode == 37) { // tombol arah  kiri
            formasi2 -= 2;
        } else if (keyCode == 39) { // tombol arah kanan
            formasi2 += 2;
        } 
    }
}
