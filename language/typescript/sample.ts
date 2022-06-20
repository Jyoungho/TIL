export class DocumentParticipant {
  readonly role?: string;
}

function allOnes(participants: DocumentParticipant[]) {
  console.log(participants);
}

allOnes(null);
