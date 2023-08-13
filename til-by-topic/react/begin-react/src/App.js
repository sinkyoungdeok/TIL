import React from 'react';
import Hello from './Hello';
import Wrapper from "./wrapper";

function App() {
  return (
      <Wrapper>
        <Hello name="react" color="red" isSpecial/>
        <Hello color="pink"/>
      </Wrapper>
  );
}

export default App;