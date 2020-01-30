<ul class="breadcrumb">
			<li><a href="${context}/homePage.do">Home</a> <span class="divider">/</span></li>
			<c:choose>
				<c:when test="${source eq 'searchResults'}">
				<li>
					<a href="${context}/${source}.do?command=getSearchDealDetail&DealRequestID=${sessionScope.deal.dealSeqId}"><t:getSection source="${source}"></t:getSection></a> <span class="divider">/</span>
				</li>
				</c:when>
				<c:when test="${source eq 'pipelineReview/pipelineReviewDeal'}">
				<li>
					<a href="${context}/pipelineReview/pipelineReviewView.do?command=executeInbox"><t:getSection source="pipelineReview"></t:getSection></a> <span class="divider">/</span>
				</li>
				<li>
					<a href="${context}/${source}.do?command=getPipelineReviewDealDetail&DealRequestID=${sessionScope.deal.dealSeqId}"><t:getSection source="${source}"></t:getSection></a> <span class="divider">/</span>
				</li>	
				</c:when>
				<c:when test="${source eq 'pipelineReviewCPALeg'}">
				<li>
					<a href="${context}/pipelineReview/pipelineReviewView.do?command=executeInbox"><t:getSection source="pipelineReview"></t:getSection></a> <span class="divider">/</span>
				</li>
				<li>
					<a href="${context}/pipelineReview/pipelineReviewDeal.do?command=getPipelineReviewDealDetail&DealRequestID=${sessionScope.deal.dealSeqId}"><t:getSection source="${source}"></t:getSection></a> <span class="divider">/</span>
				</li>	
				</c:when>
				<c:otherwise>
				<li>
					<a href="${context}/${source}.do?command=load&DealRequestID=${sessionScope.deal.dealSeqId}"><t:getSection source="${source}"></t:getSection></a> <span class="divider">/</span>
				</li>
				</c:otherwise>
			</c:choose>
			<li class="active">${legSummary.transactionEventType}</li>
		</ul>