import React, {useRef} from "react";
import "../styles/board.css"

const processWriteok = async(formValues) => {

    fetch('http://localhost:8080/api/board/write',  {
        method: 'POST',
        headers: {
            'content-type': 'application/json',
        },
        body: JSON.stringify(formValues)
    }).then(async response=>{
        if (response.ok) {
            alert('글쓰기 완료되었습니다.');

        }else if( response.status === 400 ){
            alert('회원가입에 실패했습니다. 다시 시도해주세요. ');
        }
    }).catch(error=>{
        console.log('글쓰기 error : ', error);
        alert('서버와 통신중 오류가 발생했습니다. 관리자에게 문의하세요 ');
    })
}; //processWriteok

// BoardList 함수 컴포넌트 정의
const BoardWrite = () => {

    // form 요소 참조를 위한 ref 변수 생성
    const formWriteRef = useRef(null);

    // 폼데이터 제출시 데이터 처리
    const handleWriteSubmit = (e) =>{
      e.preventDefault();

      // formdata api를 사용해 form데이터 수집
        const formData= new FormData();
        const formValues =  Object.fromEntries(formData.entries());

        console.log(formValues);

        // 글쓰기 API 호출
        processWriteok(formValues);


    };

    return (
        <main id="content">
            <h2>게시판 글쓰기</h2>
            <form name="boardfrm" id="boardfrm" method="post"
                  ref={formWriteRef} onSubmit={handleWriteSubmit} noValidate>

                <div className="form-floating my-2">
                    <input type="text" name="userid" id="userid" className="form-control"
                           placeholder="아이디" readOnly />
                    <label htmlFor="userid" className="form-label">아이디</label>
                </div>

                <div className="form-floating my-2">
                    <input type="text" name="title" id="title" className="form-control"
                           placeholder="제목" required/>
                    <label htmlFor="title" className="form-label">제목</label>
                </div>

                <div className="form-floating my-2">
                    <textarea name="contents" id="contents" className="form-control h-100"
                              rows="10" placeholder="본문글" required></textarea>
                    <label htmlFor="contents" className="form-label">본문글</label>
                </div>

                <div className="my-2 d-flex justify-content-center">
                    <div className="g-recaptcha" id="recaptcha"></div>
                </div>

                <div className="my-2 d-flex justify-content-between">
                    <button type="submit" className="btn btn-primary">
                        <i className="fa-sharp fa-solid fa-file-signature"></i> 입력완료
                    </button>
                    <button type="reset" className="btn btn-danger">
                        <i className="fa-sharp fa-solid fa-eraser"></i> 다시입력
                    </button>
                </div>
            </form>
        </main>
    )
}

export default BoardWrite;