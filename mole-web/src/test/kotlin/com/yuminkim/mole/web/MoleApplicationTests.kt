package com.yuminkim.mole.web

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.extensions.spring.SpringExtension
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ForumApplicationTests : DescribeSpec() {
    override fun extensions() = listOf(SpringExtension)

    init {
        this.describe("main") {
            context("with nothing") {
                it("should load context") {
                }
            }
        }
    }
}
