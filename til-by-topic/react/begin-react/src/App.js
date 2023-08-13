import React, {useRef} from 'react';
import UserList from './UserList';

function App() {
    const users = [
        {
            id: 1,
            username: 'tlsrudejr',
            email: 'tlsrudejr123@gmail.com'
        },
        {
            id: 2,
            username: 'tester',
            email: 'tester@example.com'
        },
        {
            id: 3,
            username: 'liz',
            email: 'liz@example.com'
        }
    ];

    const nextId = useRef(4);
    const onCreate = () => {
        nextId.current += 1;
    }
    return <UserList users={users} />;
}

export default App;