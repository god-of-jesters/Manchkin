package com.manchkin

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.ScreenUtils
import com.badlogic.gdx.utils.viewport.FitViewport

class Main: ApplicationAdapter() {
    private lateinit var batch: SpriteBatch
    private lateinit var image: Texture
    private lateinit var viewport: FitViewport
    lateinit var back:Texture
    override fun create() {
        batch = SpriteBatch()
        image = Texture("images.jpg")
        back = Texture("tab.jpg")
        viewport = FitViewport(19.5f, 9f)
    }

    override fun resize(width: Int, height: Int) {
        viewport.update(width, height, true)
    }

    override fun render() {
        ScreenUtils.clear(Color.BLACK)
        batch.setProjectionMatrix(viewport.camera.combined)
        batch.begin()

        var world_height = viewport.getWorldHeight()
        var world_width = viewport.getWorldWidth()

        batch.draw(back, 0f, 0f, world_width, world_height)
        batch.draw(image, 0f, 0f, 2f, 2f)

        batch.end()
    }

    override fun dispose() {
        batch.dispose()
        image.dispose()
    }
}
