package com.stan.snakex

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Vector2

class Snake constructor(p_id: Int) {
    var player_id = p_id

    var look_rotation = 0
    var past_rotations = MutableList(0) {}

    var head = Vector2(1280f / 2,720f / 2)
    var tail_size = 4

    var speed = 2.4f

    fun draw_self(r: ShapeRenderer) {
        var rest_of_snake = 0

        r.begin(ShapeRenderer.ShapeType.Filled)

        r.color = Color.GREEN
        r.circle(head.x,head.y, 20f)

        r.color = Color.RED
        while (rest_of_snake < tail_size) {
            rest_of_snake++

            var offset = rest_of_snake * 20

            r.circle(head.x - offset, head.y, 18f)
        }

        r.end()
    }

    fun update() {
        if(Gdx.input.isTouched) {
            var x = Gdx.input.getX()

            if (x > (1280 / 2))
                look_rotation = 0
            else
                look_rotation = 1
        }

        if (look_rotation == 0)
            head.add(speed,0f)
        if (look_rotation == 1)
            head.add(-speed,0f)
    }
}