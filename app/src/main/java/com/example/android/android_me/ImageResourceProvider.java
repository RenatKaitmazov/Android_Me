package com.example.android.android_me;

import java.util.ArrayList;

/**
 * @author Renat Kaitmazov
 */


public final class ImageResourceProvider {

    /*------------------------------------------------------------------------*/
    // Static
    /*------------------------------------------------------------------------*/

    private static final ArrayList<Integer> HEADS = new ArrayList<>(12);
    private static final ArrayList<Integer> BODIES = new ArrayList<>(12);
    private static final ArrayList<Integer> LEGS = new ArrayList<>(12);
    private static final ArrayList<Integer> ALL = new ArrayList<>(36);

    static {
        HEADS.add(R.drawable.head1);
        HEADS.add(R.drawable.head2);
        HEADS.add(R.drawable.head3);
        HEADS.add(R.drawable.head4);
        HEADS.add(R.drawable.head5);
        HEADS.add(R.drawable.head6);
        HEADS.add(R.drawable.head7);
        HEADS.add(R.drawable.head8);
        HEADS.add(R.drawable.head9);
        HEADS.add(R.drawable.head10);
        HEADS.add(R.drawable.head11);
        HEADS.add(R.drawable.head12);

        BODIES.add(R.drawable.body1);
        BODIES.add(R.drawable.body2);
        BODIES.add(R.drawable.body3);
        BODIES.add(R.drawable.body4);
        BODIES.add(R.drawable.body5);
        BODIES.add(R.drawable.body6);
        BODIES.add(R.drawable.body7);
        BODIES.add(R.drawable.body8);
        BODIES.add(R.drawable.body9);
        BODIES.add(R.drawable.body10);
        BODIES.add(R.drawable.body11);
        BODIES.add(R.drawable.body12);

        LEGS.add(R.drawable.legs1);
        LEGS.add(R.drawable.legs2);
        LEGS.add(R.drawable.legs3);
        LEGS.add(R.drawable.legs4);
        LEGS.add(R.drawable.legs5);
        LEGS.add(R.drawable.legs6);
        LEGS.add(R.drawable.legs7);
        LEGS.add(R.drawable.legs8);
        LEGS.add(R.drawable.legs9);
        LEGS.add(R.drawable.legs10);
        LEGS.add(R.drawable.legs11);
        LEGS.add(R.drawable.legs12);

        ALL.addAll(HEADS);
        ALL.addAll(BODIES);
        ALL.addAll(LEGS);
    }

    /*------------------------------------------------------------------------*/
    // Constructors
    /*------------------------------------------------------------------------*/

    private ImageResourceProvider() {
    }

    /*------------------------------------------------------------------------*/
    // API
    /*------------------------------------------------------------------------*/

    public static ArrayList<Integer> getHeads() {
        return HEADS;
    }

    public static ArrayList<Integer> getBodies() {
        return BODIES;
    }

    public static ArrayList<Integer> getLegs() {
        return LEGS;
    }

    public static ArrayList<Integer> getAll() {
        return ALL;
    }
}
