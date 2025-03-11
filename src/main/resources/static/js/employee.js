/**
 * 従業員情報を管理するためのAJAXリクエストを提供するJavaScriptコード
 * 変換元: なし（新規作成）
 * 概要: Java Springとの通信を行い、従業員情報のCRUD操作を実装
 */

// 従業員情報を取得する
function fetchEmployees() {
    return fetch('/api/employees')
        .then(response => response.json())
        .then(data => {
            console.log('従業員情報取得成功:', data);
            return data;
        })
        .catch(error => console.error('従業員情報取得エラー:', error));
}

// 新しい従業員を作成する
function createEmployee(employee) {
    return fetch('/api/employees', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(employee)
    })
    .then(response => response.json())
    .then(data => {
        console.log('従業員作成成功:', data);
        return data;
    })
    .catch(error => console.error('従業員作成エラー:', error));
}

// 従業員情報を更新する
function updateEmployee(id, employee) {
    return fetch(`/api/employees/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(employee)
    })
    .then(response => response.json())
    .then(data => {
        console.log('従業員更新成功:', data);
        return data;
    })
    .catch(error => console.error('従業員更新エラー:', error));
}

// 従業員情報を削除する
function deleteEmployee(id) {
    return fetch(`/api/employees/${id}`, {
        method: 'DELETE'
    })
    .then(response => {
        if (response.ok) {
            console.log('従業員削除成功');
        } else {
            console.error('従業員削除エラー');
        }
    })
    .catch(error => console.error('従業員削除エラー:', error));
}