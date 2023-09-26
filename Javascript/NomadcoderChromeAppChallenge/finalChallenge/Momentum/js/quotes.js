const quotes = [
    {
        quote: "All men by nature desire knowledge.",
        author: "Aristotle",
    },
    {
        quote: "When you have faults, do not fear to abandon them.",
        author: "Confucius",
    },
    {
        quote: "It takes 20 years to build a reputation and five minutes to ruin it. If you think about that, you'll do things differently.",
        author: "Warren Buffett",
    },
    {
        quote: "I have always thought the actions of men the best interpreters of their thoughts.",
        author: "John Locke",
    },
    {
        quote: "The friendship that can cease has never been real.",
        author: "Saint Jerome",
    },
    {
        quote: "Friends have all things in common.",
        author: "Plato",
    },
    {
        quote: "A friend is a second self.",
        author: "Aristotle",
    },
    {
        quote: "I never think of the future - it comes soon enough.",
        author: "Albert Einstein",
    },
    {
        quote: "The best thing about the future is that it comes one day at a time.",
        author: "Abraham Lincoln",
    },
    {
        quote: "The future, according to some scientists, will be exactly like the past, only far more expensive.",
        author: "John Sladek",
    },
    {
        quote: "There is never enough time, unless you're serving it.",
        author: "Malcolm Forbes",
    }
]

const quote = document.querySelector("#quote span:first-child");
const author = document.querySelector("#quote span:last-child");

const todaysQuote = quotes[Math.floor(Math.random() * quotes.length)];

quote.innerText = todaysQuote.quote;
author.innerText = `- ${todaysQuote.author} -`;
