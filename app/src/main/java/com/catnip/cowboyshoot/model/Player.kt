package com.catnip.cowboyshoot.model

import com.catnip.cowboyshoot.enum.PlayerPosition
import com.catnip.cowboyshoot.enum.PlayerSide
import com.catnip.cowboyshoot.enum.PlayerState


/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
data class Player(
    val playerSide: PlayerSide,
    var playerState: PlayerState,
    var playerPosition: PlayerPosition
)