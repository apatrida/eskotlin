/*
 * Copyright (c) 2016. Michael Buhot m.buhot@gmail.com
 */
package mbuhot.eskotlin.query

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.Assert.assertEquals


val jsonMapper = ObjectMapper()
fun json_normalize(str: String) : String = jsonMapper.readTree(str).let { jsonMapper.writeValueAsString(it) }

infix fun <T> T.should_render_as(jsonStr: String) {
    assertEquals(json_normalize(jsonStr), json_normalize(this.toString()))
}

