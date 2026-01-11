#!/bin/bash
# Push Aura to GitHub
# Usage: ./push-to-github.sh YOUR_GITHUB_USERNAME

if [ -z "$1" ]; then
    echo "Usage: ./push-to-github.sh YOUR_GITHUB_USERNAME"
    echo "Example: ./push-to-github.sh joao-silva"
    exit 1
fi

USERNAME=$1
REPO_URL="https://github.com/$USERNAME/aura-lang.git"

echo "=========================================="
echo "Pushing Aura to GitHub"
echo "=========================================="
echo ""
echo "Username: $USERNAME"
echo "Repo URL: $REPO_URL"
echo ""

# Change to project directory
cd /Volumes/SSD_240G/blueprints/aura || exit

# Step 1: Add all files
echo "1️⃣  Adding all files..."
git add .
if [ $? -ne 0 ]; then
    echo "❌ Failed to add files"
    exit 1
fi
echo "✅ Files added"
echo ""

# Step 2: Commit
echo "2️⃣  Creating commit..."
git commit -m "Aura Language - Phase 4 Complete: Production-ready transpiler with stdlib and CLI" || echo "⚠️  Already committed"
if [ $? -ne 0 ]; then
    echo "⚠️  No changes to commit (or already committed)"
fi
echo "✅ Commit ready"
echo ""

# Step 3: Remove old remotes
echo "3️⃣  Cleaning up old remotes..."
git remote remove origin 2>/dev/null || true
git remote remove upstream 2>/dev/null || true
echo "✅ Old remotes removed"
echo ""

# Step 4: Add new remote
echo "4️⃣  Adding new remote..."
git remote add origin "$REPO_URL"
if [ $? -ne 0 ]; then
    echo "❌ Failed to add remote"
    exit 1
fi
echo "✅ Remote added: $REPO_URL"
echo ""

# Step 5: Rename branch to main
echo "5️⃣  Renaming branch to main..."
git branch -M main 2>/dev/null || true
echo "✅ Branch renamed to main"
echo ""

# Step 6: Push
echo "6️⃣  Pushing to GitHub..."
echo "   (You may need to enter GitHub credentials)"
echo ""
git push -u origin main

if [ $? -eq 0 ]; then
    echo ""
    echo "=========================================="
    echo "✅ SUCCESS! Aura is now on GitHub!"
    echo "=========================================="
    echo ""
    echo "Repository: https://github.com/$USERNAME/aura-lang"
    echo ""
    echo "Next steps:"
    echo "1. Add description and topics on GitHub"
    echo "2. Create GitHub issues for Phase 5"
    echo "3. Publicize on Reddit, HackerNews, Dev.to"
    echo ""
else
    echo ""
    echo "=========================================="
    echo "❌ Push failed!"
    echo "=========================================="
    echo ""
    echo "Possible solutions:"
    echo "1. Check your GitHub credentials"
    echo "2. Ensure the repository exists: https://github.com/$USERNAME/aura-lang"
    echo "3. Check your GitHub SSH/token settings"
    echo ""
fi
