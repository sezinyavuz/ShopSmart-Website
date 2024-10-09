import React, { useEffect, useState } from 'react';
import axios from 'axios';
import styles from './QuestionsPage.module.css';

const QuestionsPage = () => {
  const [questions, setQuestions] = useState([]);

  useEffect(() => {
    const fetchQuestions = async () => {
      try {
        const response = await axios.get('http://localhost:8080/questions');
        setQuestions(response.data);
      } catch (error) {
        console.error('Error fetching questions:', error);
      }
    };

    fetchQuestions();
  }, []);

  return (
    <div className={styles.page}>
      <h2>Questions</h2>
      <ul>
        {questions.map((question) => (
          <li key={question.id}>{question.content}</li>
        ))}
      </ul>
    </div>
  );
};

export default QuestionsPage;
