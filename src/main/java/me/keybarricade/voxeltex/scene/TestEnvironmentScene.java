package me.keybarricade.voxeltex.scene;

import me.keybarricade.voxeltex.component.drawable.line.AxisDrawComponent;
import me.keybarricade.voxeltex.component.drawable.line.GridDrawComponent;
import me.keybarricade.voxeltex.gameobject.GameObject;
import me.keybarricade.voxeltex.material.Material;
import me.keybarricade.voxeltex.prefab.camera.FpsCameraPrefab;
import me.keybarricade.voxeltex.prefab.primitive.CubePrefab;
import me.keybarricade.voxeltex.prefab.primitive.QuadPrefab;
import me.keybarricade.voxeltex.shader.ShaderManager;
import me.keybarricade.voxeltex.shader.specific.TexturedShader;
import me.keybarricade.voxeltex.texture.Image;
import me.keybarricade.voxeltex.texture.Texture;
import org.joml.Quaternionf;
import org.joml.Vector2f;
import org.joml.Vector3f;

public class TestEnvironmentScene extends Scene {

    @Override
    public void load() {
        // Load the super
        super.load();

        // Load the box texture
        Texture boxTexture = Texture.fromImage(Image.loadFromEngineAssets("images/box.png"));
        Material boxMaterial = new Material(ShaderManager.SHADER_DEFAULT_TEXTURED, boxTexture);

        // Create the main camera object
        FpsCameraPrefab fpsCameraPrefab = new FpsCameraPrefab();
        fpsCameraPrefab.getTransform().setPosition(new Vector3f(0.5f, 1.50f, 5.0f));
        addGameObject(fpsCameraPrefab);

        // Create an object to render the center axis and grid
        GameObject gridObject = new GameObject("AxisGridRenderer");
//        gridObject.addComponent(new GridDrawComponent());
        gridObject.addComponent(new AxisDrawComponent());
        addGameObject(gridObject);

        // Create a basic cube
        CubePrefab baseObject = new CubePrefab();
        baseObject.getTransform().setPosition(new Vector3f(-1.0f, 0.5f, -1.5f));
        baseObject.getTransform().setAngularVelocity(new Vector3f(0, 0.5f, 0));
        baseObject.setMaterial(boxMaterial);
        addGameObject(baseObject);

        // Add a basic sub cube
        CubePrefab subObject1 = new CubePrefab();
        subObject1.getTransform().setAngularVelocity(new Vector3f(0.0f, 2.5f, 0.0f));
        subObject1.getTransform().setPosition(new Vector3f(1.5f, 1.5f, 0));
        subObject1.setMaterial(boxMaterial);
        baseObject.addChild(subObject1);

        // Add a basic sub cube
        CubePrefab subObject2 = new CubePrefab();
        subObject2.getTransform().setAngularVelocity(new Vector3f(0.0f, 3.0f, 0.0f));
        subObject2.getTransform().setPosition(new Vector3f(1.5f, 1.5f, 0));
        subObject2.setMaterial(boxMaterial);
        subObject1.addChild(subObject2);

        // Add a basic sub cube
        CubePrefab subObject3 = new CubePrefab();
        subObject3.getTransform().setPosition(new Vector3f(-1.5f, 1.5f, 0));
        subObject3.getTransform().setRotation(new Quaternionf(0.25f, 0, 0));
        subObject3.getTransform().setAngularVelocity(new Vector3f(0, -3.3f, 0));
        subObject3.setMaterial(boxMaterial);
        subObject1.addChild(subObject3);

        // Add a basic sub cube
        CubePrefab subObject4 = new CubePrefab();
        subObject4.getTransform().setPosition(new Vector3f(0, 1.35f, 0));
        subObject4.getTransform().setAngularVelocity(new Vector3f(3.1f, 4.2f, 2.9f));
        subObject4.setMaterial(boxMaterial);
        subObject3.addChild(subObject4);
        for(int i = 0; i < 10; i++) {
            // Load the texture shader
            CubePrefab quadTest = new CubePrefab();
            quadTest.getTransform().setPosition(new Vector3f(4, 0.5f, 5.0f - 1.5f * i));
            addGameObject(quadTest);
            quadTest.setMaterial(boxMaterial);
        }

        // Load the sand texture
        Texture sandTexture = Texture.fromImage(Image.loadFromEngineAssets("images/sand.png"));
        Material sandMaterial = new Material(ShaderManager.SHADER_DEFAULT_TEXTURED, sandTexture);
        sandMaterial.getTiling().set(3.0f);

        QuadPrefab quad = new QuadPrefab("Quad", new Vector2f(20.0f, 20.0f));
        quad.setMaterial(sandMaterial);
        addGameObject(quad);
    }
}
