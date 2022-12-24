/**
 * 
 */

console.log(boardNumber);
console.log("안녕");

show();

function show() {
	$.ajax({
		url: "/reply/listOk.re",
		type: "get",
		data: { boardNumber: boardNumber },
		contentType: "application/json; charset=utf-8",
		dataType: "json",
		success: showList
	});
}

function showList(replies) {
	if (replies.length > 0) {
		let text = "";
		replies.forEach(reply => {
			text += `<div class="reply">`;
			text += `<div class="info">`
			text += `<p class="writer">` + reply.memberId + `</p>`;
			text += `<p class="date">` + reply.replyDate + `</p>`;
			text += `</div>`
			text += `<div class="content" style="width:100%">`;
			text += `<pre>` + reply.replyContent + `</pre>`;
			text += `</div>`;
			if (reply.memberId == memberId) {
				text += `<div class="button-wrap">`;
				text += `<div class="modify-button" data-number=` + reply.replyNumber + `></div>`;
				text += `<div class="delete-button" data-number=` + reply.replyNumber + `></div>`;
				text += `</div>`;
			}
			text += `</div>`;
		});
		$("#replies").html(text);
	}
}

$("#replies").on("click","div.delete-button",function(){
	let replyNumber = $(this).data('number');
	$.ajax({
		url: "/reply/deleteOk.re",
		type: 'get',
		data: {replyNumber:replyNumber},
		contentType: "application/json; charset = utf-8",
		success: show()
	})
})

function send() {
	let replyContent = replyForm.replyContent.value;
	console.log(replyForm.replyContent.value);
	console.log(memberId);
	if (!replyContent) {
		alert('댓글을 입력해주세요')
		return;
	}

	$.ajax({
		url: "/reply/writeOk.re",
		type: 'get',
		data: { boardNumber: boardNumber, replyContent: replyContent, memberNumber: memberNumber },
		contentType: "application/json; charset = utf-8",
		dataType: 'json',
		success: show()
	})
}