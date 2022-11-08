package com.kdsin.issueservice.service

import com.kdsin.issueservice.domain.Issue
import com.kdsin.issueservice.domain.IssueRepository
import com.kdsin.issueservice.model.IssueRequest
import com.kdsin.issueservice.model.IssueResponse
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class IssueService (
    private val issueRepository: IssueRepository,
) {

    @Transactional
    fun create(userId: Long, request: IssueRequest): IssueResponse {

        val issue = Issue(
            summary = request.summary,
            description = request.description,
            userId = userId,
            type = request.type,
            priority = request.priority,
            status = request.status,
        )

        return IssueResponse(issueRepository.save(issue))
    }
}