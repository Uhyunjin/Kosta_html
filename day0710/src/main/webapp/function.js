//배열을 매개변수로 전달받아 순서없는 목록을 만들어서 반환하는 함수를 갖고있는 외부 스크립트 만들기
let printList=function(arr){
	let list="<ul>"
	for(i=0;i<arr.length;i++){
		list+="<li>"
		list+=arr[i]
		list+="</li>"
	}
	list+="</ul>"
	
	return list;
}