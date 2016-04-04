package me.keybarricade.voxeltex.font;

import me.keybarricade.voxeltex.material.Material;
import me.keybarricade.voxeltex.texture.Texture;

public class BitmapFont {

    /**
     * The texture name.
     */
    private String name;

    /**
     * The texture texture.
     */
    private Texture texture;

    /**
     * Font material.
     */
    private Material material;

    /**
     * Constructor.
     *
     * @param name Font name.
     * @param fontTexture Font texture.
     */
    public BitmapFont(String name, Texture fontTexture) {
        this.name = name;
        this.texture = fontTexture;
    }

    /**
     * Get the texture name.
     *
     * @return Font name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set the texture name.
     *
     * @param name Font name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the texture texture.
     *
     * @return Font texture.
     */
    public Texture getFontTexture() {
        return this.texture;
    }

    /**
     * Set the texture texture.
     *
     * @param font Font texture.
     */
    public void setFontTexture(Texture font) {
        this.texture = font;
    }

    /**
     * Get the bitmap texture material.
     *
     * @return Bitmap texture material.
     */
    public Material getMaterial() {
        // Make sure a texture material has been created
        if(this.material == null) {
            // Show a status message
            System.out.println("Creating bitmap material for '" + getName() + "' font...");

            // Create the actual material
            this.material = new Material(this.texture);
        }

        // TODO: Load the proper shader!

        // Return the material
        return this.material;
    }
}
