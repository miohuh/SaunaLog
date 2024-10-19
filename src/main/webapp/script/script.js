function toggleMenu() {
    const menu = document.querySelector('.menu-content');
    menu.classList.toggle('active');  // activeクラスを追加/削除する
}

document.addEventListener('DOMContentLoaded', function() {
    const impression = document.querySelector('.impression');
    impression.style.maxHeight = `${impression.scrollHeight}px`; // 自動的に高さを設定
});


 const impressionTextarea = document.getElementById('impression');

  impressionTextarea.addEventListener('input', function() {
    // textareaの内容を取得
    let content = impressionTextarea.value;
    
    // 改行を反映した内容をコンソールに出力
    console.log(content.replace(/\n/g, "\\n"));  // \nを改行に変換して表示
  });