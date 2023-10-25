/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jansen.lottogenerator.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Rolf
 */
@Entity
public class SixOfFortyNinePojo implements Serializable {

    @Id
    private Long id;

    @Column(name = "Z1")
    private int z1 = 0;

    @Column(name = "Z2")
    private int z2 = 0;

    @Column(name = "Z3")
    private int z3 = 0;

    @Column(name = "Z4")
    private int z4 = 0;

    @Column(name = "Z5")
    private int z5 = 0;

    @Column(name = "Z6")
    private int z6 = 0;

    public void setZ1(int z) {
        if (z1 != z) {
            z1 = z;
        }
    }

    public int getZ1() {
        return z1;
    }

    public void setZ2(int z) {
        if (z2 != z) {
            z2 = z;
        }
    }

    public int getZ2() {
        return z2;
    }

    public void setZ3(int z) {
        if (z3 != z) {
            z3 = z;
        }
    }

    public int getZ3() {
        return z3;
    }

    public void setZ4(int z) {
        if (z4 != z) {
            z4 = z;
        }
    }

    public int getZ4() {
        return z4;
    }

    public void setZ5(int z) {
        if (z5 != z) {
            z5 = z;
        }
    }

    public int getZ5() {
        return z5;
    }

    public void setZ6(int z) {
        if (z6 != z) {
            z6 = z;
        }
    }

    public int getZ6() {
        return z6;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s", this.getZ1(), this.getZ2(), this.getZ3(), this.getZ4(), this.getZ5(), this.getZ6());
    }
}
