/******************************************************************************
 * Copyright (c) Tim Visee 2016. All rights reserved.                         *
 *                                                                            *
 * @author Tim Visee                                                          *
 * @website http://timvisee.com/                                              *
 *                                                                            *
 * Open Source != No Copyright                                                *
 *                                                                            *
 * Permission is hereby granted, free of charge, to any person obtaining a    *
 * copy of this software and associated documentation files (the "Software"), *
 * to deal in the Software without restriction, including without limitation  *
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,   *
 * and/or sell copies of the Software, and to permit persons to whom the      *
 * Software is furnished to do so, subject to the following conditions:       *
 *                                                                            *
 * The above copyright notice and this permission notice shall be included    *
 * in all copies or substantial portions of the Software.                     *
 *                                                                            *
 * You should have received a copy of The MIT License (MIT) along with this   *
 * program. If not, see <http://opensource.org/licenses/MIT/>.                *
 ******************************************************************************/

package com.timvisee.voxeltex.prefab.camera;

import com.timvisee.voxeltex.structure.component.camera.MouseLookCameraComponent;
import com.timvisee.voxeltex.structure.gameobject.GameObject;

public class MouseLookCameraPrefab extends GameObject {

    /**
     * The default name of the camera object.
     */
    private static final String DEFAULT_NAME = "MouseLookCameraPrefab";

    /**
     * Constructor.
     */
    public MouseLookCameraPrefab() {
        super(DEFAULT_NAME);
    }

    /**
     * Constructor.
     *
     * @param name Game object name.
     */
    public MouseLookCameraPrefab(String name) {
        super(name);
    }

    @Override
    public void create() {
        // Call the super
        super.create();

        // Add the mouse look camera component
        addComponent(new MouseLookCameraComponent());
    }
}
