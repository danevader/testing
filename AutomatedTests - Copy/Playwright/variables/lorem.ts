import { LoremIpsum } from "lorem-ipsum";

const lorem = new LoremIpsum({
  sentencesPerParagraph: {
    max: 6,
    min: 3,
  },
  wordsPerSentence: {
    max: 13,
    min: 6,
  },
});

const generatedMessage = {
  Subject: lorem.generateWords(3),
  Body: lorem.generateParagraphs(2),
};

export { lorem, generatedMessage };
