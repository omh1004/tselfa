// API 기본 URL
const API_URL = 'http://localhost:8080/api';

// Fetch 요청에 공통적으로 사용될 헤더와 옵션
const headers = {
    'Content-Type': 'application/json'
};

export default {
    async getAllUsers() {
        try {
            const response = await fetch(`${API_URL}/users`);
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            return await response.json();
        } catch (error) {
            console.error('사용자 목록 조회 오류:', error);
            throw error;
        }
    },

    async getUserById(id) {
        try {
            const response = await fetch(`${API_URL}/users/${id}`);
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            return await response.json();
        } catch (error) {
            console.error(`사용자 조회 오류 (ID: ${id}):`, error);
            throw error;
        }
    },

    async createUser(user) {
        try {
            const response = await fetch(`${API_URL}/users`, {
                method: 'POST',
                headers,
                body: JSON.stringify(user)
            });
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            return await response.json();
        } catch (error) {
            console.error('사용자 생성 오류:', error);
            throw error;
        }
    },

    async updateUser(id, user) {
        try {
            const response = await fetch(`${API_URL}/users/${id}`, {
                method: 'PUT',
                headers,
                body: JSON.stringify(user)
            });
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            return await response.json();
        } catch (error) {
            console.error(`사용자 수정 오류 (ID: ${id}):`, error);
            throw error;
        }
    },

    async deleteUser(id) {
        try {
            const response = await fetch(`${API_URL}/users/${id}`, {
                method: 'DELETE'
            });
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            return true;
        } catch (error) {
            console.error(`사용자 삭제 오류 (ID: ${id}):`, error);
            throw error;
        }
    }
}