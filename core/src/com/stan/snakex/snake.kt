package com.stan.snakex

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Vector2

class Snake constructor(p_id: Int) {
    var player_id = p_id

    var position = Vector2(1280f / 2,720f / 2)

    var size = 4

    fun draw_self(r: ShapeRenderer) {
        r.begin(ShapeRenderer.ShapeType.Filled)

        r.color = Color.GREEN
        r.circle(position.x,position.y, 20f)

        r.color = Color.RED

        var rest_of_snake = 0
        while (rest_of_snake < size) {
            rest_of_snake++

            var offset = rest_of_snake * 22

            r.circle(position.x - offset,position.y - offset, 20f)
        }

        r.end()
    }

    fun update() {
        if(Gdx.input.isTouched) {
            var x = Gdx.input.getX()

            if (x > (1280 / 2))
                position = Vector2( position.x + 1f,position.y + 0f)
            else
                position = Vector2( position.x - 1f,position.y + 0f)
        }
    }
}