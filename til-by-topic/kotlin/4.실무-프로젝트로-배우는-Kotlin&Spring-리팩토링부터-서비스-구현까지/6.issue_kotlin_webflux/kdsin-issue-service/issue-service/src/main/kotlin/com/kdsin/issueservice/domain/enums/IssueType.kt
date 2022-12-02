package com.kdsin.issueservice.domain.enums

enum class IssueType {

    BUG, TASK;

    companion object {
//        fun of (type: String) = valueOf(type.uppercase())
        operator fun invoke(type:String) = valueOf(type.uppercase())
    }
}

//fun main() {
//
//    val type = IssueType("BUG")
//    IssueType.BUG == type
//}